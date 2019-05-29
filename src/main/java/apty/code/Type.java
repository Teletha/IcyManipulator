/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package apty.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor9;

public class Type implements Codable {

    /** The package name. */
    private final String packageName;

    /** The simple class name. */
    private final String className;

    /** The variable expression. */
    private final List<Type> variable = new ArrayList();

    /** The type kind. */
    public final TypeKind kind;

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param packageName
     * @param className
     * @param generic
     */
    private Type(String fqcn, List<Type> variables, TypeKind kind) {
        this(computePackage(fqcn), computeName(fqcn), variables, kind);
    }

    /**
     * Compute package name.
     * 
     * @param fqcn
     * @return
     */
    private static String computePackage(String fqcn) {
        int index = fqcn.lastIndexOf(".");

        return index == -1 ? "" : fqcn.substring(0, index);
    }

    /**
     * Compute base name.
     * 
     * @param fqcn
     * @return
     */
    private static String computeName(String fqcn) {
        int index = fqcn.lastIndexOf(".");

        return index == -1 ? fqcn : fqcn.substring(index + 1);
    }

    /**
     * <p>
     * Immutable Type.
     * </p>
     * 
     * @param packageName
     * @param className
     * @param generic
     */
    private Type(String packageName, String className, List<Type> variables, TypeKind kind) {
        this.packageName = packageName;
        this.className = className;
        this.variable.addAll(variables);
        this.kind = kind;
    }

    /**
     * Compute fully qualified class name.
     * 
     * @return
     */
    public String name() {
        if (packageName.isEmpty()) {
            return className;
        } else {
            return packageName + "." + className;
        }
    }

    /**
     * Compute default value literal.
     * 
     * @return
     */
    public String defaultValue() {
        switch (className) {
        case "int":
        case "byte":
        case "short":
            return "0";

        case "long":
            return "0L";

        case "float":
            return "0";

        case "double":
            return "0D";

        case "char":
            return "' '";

        case "boolean":
            return "false";

        default:
            return "null";
        }
    }

    /**
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Class type) {
        return name().equals(type.getName());
    }

    /**
     * Chech type equality.
     * 
     * @param type
     * @return
     */
    public boolean is(Type type) {
        return name().equals(type.name());
    }

    /**
     * Create vararged type if this type is array.
     * 
     * @return
     */
    public Type varargnize() {
        if (kind == TypeKind.ARRAY) {
            return new Type(packageName, className.replaceAll("\\[\\]$", "..."), variable, TypeKind.DECLARED);
        } else {
            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Coder coder) {
        if (kind == TypeKind.WILDCARD) {
            StringJoiner types = new StringJoiner(" & ", className, "");
            variable.forEach(v -> types.add(v.write(coder)));
            return types.toString();
        }

        StringJoiner joiner = new StringJoiner(", ", "<", ">").setEmptyValue("");
        for (Type type : variable) {
            joiner.add(type.write(coder));
        }

        return coder.imports(packageName, className).concat(joiner.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(packageName, className, variable, kind);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Type == false) {
            return false;
        }

        Type other = (Type) obj;

        if (!packageName.equals(other.packageName)) {
            return false;
        }

        if (!className.equals(other.className)) {
            return false;
        }

        if (!variable.toString().equals(other.variable.toString())) {
            return false;
        }

        if (kind != other.kind) {
            return false;
        }
        return true;
    }

    /**
     * <p>
     * Resoleve {@link Type} by the generic variable type.
     * </p>
     * 
     * @param fcn
     * @return
     */
    public static final Type generic(String name) {
        return new Type("", name, List.of(), TypeKind.TYPEVAR);
    }

    /**
     * <p>
     * Resoleve {@link Type} by the fully qualified class name.
     * </p>
     * 
     * @param fcn
     * @return
     */
    public static final Type of(String fqcn) {
        return new Type(fqcn, List.of(), TypeKind.DECLARED);
    }

    /**
     * <p>
     * Resoleve {@link Type} by the fully qualified class name.
     * </p>
     * 
     * @param fcn
     * @return
     */
    public static final Type of(Class type) {
        return new Type(type.getName(), List.of(), TypeKind.DECLARED);
    }

    /**
     * <p>
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    public static final Type of(TypeMirror type) {
        return type.accept(new TypeDetector(), null);
    }

    /**
     * <p>
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    public static final Type of(TypeMirror type, List<Type> variables) {
        return type.accept(new TypeDetector(), variables);
    }

    /**
     * <p>
     * Resoleve {@link Type} by {@link TypeMirror}.
     * </p>
     * 
     * @param asType
     * @return
     */
    public static final Type of(TypeElement type) {
        return type.asType().accept(new TypeDetector(), null);
    }

    /**
     * 
     */
    private static class TypeDetector extends SimpleTypeVisitor9<Type, List<Type>> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitPrimitive(PrimitiveType type, List<Type> p) {
            return new Type(type.toString(), List.of(), type.getKind());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitArray(ArrayType type, List<Type> p) {
            return new Type(type.toString(), List.of(), TypeKind.ARRAY);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitDeclared(DeclaredType type, List<Type> outer) {
            String fqcn = ((TypeElement) type.asElement()).getQualifiedName().toString();
            List<Type> variables = outer != null ? outer : type.getTypeArguments().stream().map(Type::of).collect(Collectors.toList());

            return new Type(fqcn, variables, TypeKind.DECLARED);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitTypeVariable(TypeVariable t, List<Type> p) {
            return new Type("", t.toString(), List.of(), TypeKind.TYPEVAR);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type visitWildcard(WildcardType type, List<Type> p) {
            TypeMirror extendType = type.getExtendsBound();

            if (extendType != null) {
                return new Type(null, "? extends ", List.of(extendType.accept(this, null)), TypeKind.WILDCARD);
            }

            TypeMirror superType = type.getSuperBound();

            if (superType != null) {
                return new Type(null, "? super ", List.of(superType.accept(this, null)), TypeKind.WILDCARD);
            }

            return new Type(null, "?", List.of(), TypeKind.WILDCARD);
        }
    }
}
