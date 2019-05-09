/*
 * Copyright (C) 2019 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package icy.manipulator.property.extend;

import icy.manipulator.Icy;
import icy.manipulator.property.object.Multiple;

@Icy
public abstract class SubclassModel extends Multiple {

    @Icy.Property
    public abstract String nickname();
}