/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.extend.model;

import icy.manipulator.Icy;
import icy.manipulator.property.model.Mixed;

@Icy
public abstract class MixedArbitraryModel extends Mixed {

    @Icy.Property
    public String optionZip() {
        return "";
    }
}