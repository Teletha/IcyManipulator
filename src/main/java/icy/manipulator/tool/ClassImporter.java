/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.tool;

import java.util.Set;
import java.util.TreeSet;

import icy.manipulator.tool.IcyManipulator.FQCN;

/**
 * @version 2015/06/06 22:47:16
 */
class ClassImporter {

    /** The base package name. */
    private final String basePackage;

    /** The imported classes. */
    private final Set<String> imports = new TreeSet();

    /**
     * @param basePackage
     */
    ClassImporter(String baseClass) {
        int index = baseClass.lastIndexOf(".");

        if (index == -1) {
            this.basePackage = "";
        } else {
            this.basePackage = baseClass.substring(0, index);
        }
    }

    /**
     * <p>
     * Import class.
     * </p>
     */
    String use(Class imported) {
        return use(new FQCN(imported));
    }

    /**
     * <p>
     * Import class.
     * </p>
     */
    String use(FQCN imported) {
        if (!imported.packageName.equals(basePackage) && !imported.isDefault() && !imported.isPrimitive() && !imported
                .isGeneric()) {
            imports.add(imported.toString());
        }
        return imported.classNameVariables;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String fqcn : imports) {
            builder.append("import ").append(fqcn).append(";").append(IcyManipulator.END);
        }
        return builder.toString();
    }
}