/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Processor;
import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import org.junit.jupiter.api.extension.RegisterExtension;

import antibug.CleanRoom;
import bee.Bee;
import bee.util.JavaCompiler;
import kiss.I;
import psychopath.File;
import psychopath.Locator;

public class AnnotationProcessor {

    static {
        I.load(Bee.class);
    }

    @RegisterExtension
    static CleanRoom room = new CleanRoom();

    /** Annotation processor. */
    private final Class<? extends Processor> processor;

    /**
     * @param processor
     * @param room
     */
    public AnnotationProcessor(Class<? extends Processor> processor, Class... classes) {
        this.processor = processor;

        for (Class clazz : classes) {
            requireCompiling(clazz);
        }
    }

    /**
     * Compile target class.
     * 
     * @param source A target source class.
     */
    public void requireCompiling(Class source) {
        compile(source.getName(), source.getName().replace("Model", ""));
    }

    private void compile(String compilingClass, String generatedClass) {
        File compilingSource = Locator.directory("src/test/java").file(computeSourceFile(compilingClass));
        File generatedSource = Locator.directory("src/test/java").file(computeSourceFile(generatedClass));
        File annotaionProcessorSource = Locator.directory("src/main/java").file(computeSourceFile(processor.getName()));
        File generator = Locator.directory("src/main/java").file(computeSourceFile(IcyManipulator.class.getName()));
        File depend1 = Locator.directory("src/main/java").file(computeSourceFile(CustomizerInfo.class.getName()));
        File temporaryGeneratedSource = Locator.directory(room.root).file(computeSourceFile(generatedClass));
        long date = generatedSource.lastModified();

        if (compilingSource.lastModified() < date && annotaionProcessorSource.lastModified() < date && generator
                .lastModified() < date && depend1.lastModified() < date) {
            return; // generated source file is up to date
        }

        Errors errors = new Errors();

        // compile class and generate source by annotation processor
        JavaCompiler compiler = new JavaCompiler();
        compiler.addCurrentClassPath();
        compiler.addProcessor(processor);
        compiler.addSource(compilingClass, compilingSource.text());
        compiler.setOutput(room.root);
        compiler.setErrorListener(errors);

        try {
            compiler.compile();
        } catch (Error e) {
            System.out.println(errors.errors);
            System.out.println(temporaryGeneratedSource.text());
            throw I.quiet(e);
        }

        // copy generated file to test source directory
        temporaryGeneratedSource.copyTo(generatedSource);

        throw new AssertionError(compilingClass + " was compiled. Please retry to run test.");
    }

    /**
     * Compute class file name.
     * 
     * @param className
     * @return
     */
    private String computeSourceFile(String className) {
        return className.replace('.', '/') + ".java";
    }

    /**
     * 
     */
    private static class Errors implements DiagnosticListener<JavaFileObject> {

        List<Diagnostic> errors = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
            if (diagnostic.getKind() == Kind.ERROR) {
                errors.add(diagnostic);
            }
        }
    }
}
