/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.object;

import icy.manipulator.Icy;

@Icy
public abstract class MultipleModel {

    @Icy.Property
    public abstract String name();

    @Icy.Property
    public abstract String stand();

    @Icy.Property
    public abstract int age();
}