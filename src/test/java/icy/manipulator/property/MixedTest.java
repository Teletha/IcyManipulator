/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import icy.manipulator.AnnotationProcessor;
import icy.manipulator.IcyManipulator;
import icy.manipulator.property.model.Mixed;
import icy.manipulator.property.model.MixedModel;

class MixedTest {

    @RegisterExtension
    static AnnotationProcessor processor = new AnnotationProcessor(IcyManipulator.class, MixedModel.class);

    @Test
    void onlyRequired() {
        Mixed o = Mixed.with.name("Name").age(20);
        assert o.name.equals("Name");
        assert o.age == 20;
        assert o.optionAddress.isEmpty();
        assert o.optionCommnet.isEmpty();
    }

    @Test
    void withOptions() {
        Mixed o = Mixed.with.name("Name").age(20).optionAddress("Address").optionCommnet("Comment");
        assert o.name.equals("Name");
        assert o.age == 20;
        assert o.optionAddress.equals("Address");
        assert o.optionCommnet.equals("Comment");
    }
}