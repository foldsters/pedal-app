package com.steamtechs.core.domain

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class ProportionTest {

    @Test
    @DisplayName("When init to valid value, the variable equals the input")
    fun `When init to valid value, the variable equals the input`() {
        val p: Double by Proportion(0.5)
        assertEquals(0.5, p)
    }

    @Test
    @DisplayName("When init to invalid value, an error is thrown")
    fun `When init to invalid value, an error is thrown`() {
        assertThrows<Proportion.InvalidProportionValueException> {
            var p: Double by Proportion(-0.5)
        }
    }

    @Test
    @DisplayName("When valid init is set to invalid value, an error is thrown")
    fun `When valid init is set to invalid value, an error is thrown`() {
        var p: Double by Proportion(0.5)
        assertThrows<Proportion.InvalidProportionValueException> {
            p = -0.5
        }
    }

}