/*
 * Copyright (C) 2019 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package icy.manipulator.property.base.model;

import icy.manipulator.Icy;

@Icy
public abstract class MixedModel {

    @Icy.Property
    public abstract String name();

    @Icy.Property
    String optionAddress() {
        return "";
    }

    @Icy.Property
    public abstract int age();

    @Icy.Property
    String optionCommnet() {
        return "";
    }
}