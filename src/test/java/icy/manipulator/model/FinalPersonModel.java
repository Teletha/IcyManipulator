/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.model;

import icy.manipulator.Icy;
import icy.manipulator.Initializer;

@Icy
public class FinalPersonModel {

    public final String name = null;

    public final int age = Initializer.Int();

    public final Gender gender = Gender.Female;
}
