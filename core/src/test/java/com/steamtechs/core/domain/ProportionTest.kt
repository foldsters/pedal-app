package com.steamtechs.core.domain

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class ProportionTest {

    @Test
    @DisplayName("When delegated variable is initialized with valid input, the getter returns that input")
    fun `When init to valid value, the variable equals the input`() {
        val p: Double by Proportion(0.5)
        assertEquals(0.5, p)
    }

    @Test
    @DisplayName("When delegated variable is set with valid value, the getter returns that value")
    fun `When set to valid value, the variable equals the input`() {
        var p: Double by Proportion(0.5)
        p = 0.6
        assertEquals(0.6, p)
    }

    @Test
    @DisplayName("When delegated variable is initialized to invalid value, an error is thrown")
    fun `When init to invalid value, an error is thrown`() {
        assertThrows<Proportion.InvalidProportionValueException> {
            var p: Double by Proportion(-0.5)
        }
    }

    @Test
    @DisplayName("When delegated variable is set to invalid value, an error is thrown")
    fun `When valid init is set to invalid value, an error is thrown`() {
        var p: Double by Proportion(0.5)
        assertThrows<Proportion.InvalidProportionValueException> {
            p = -0.5
        }
    }

}