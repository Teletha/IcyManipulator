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

import org.junit.Test;

/**
 * @version 2015/06/03 16:00:53
 */
public class UserDefinedDefaultValueTest {

    @Test
    public void defaultValue() {
        UserDefinedDefaultValue value = UserDefinedDefaultValue.with();
        assert value.value == "DEFAULT";
    }
}