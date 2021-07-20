package com.steamtechs.core.domain.intangible

import com.steamtechs.core.domain.intangible.Proportion
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class ProportionTest {

    @Test
    @DisplayName("When delegated variable is initialized with valid input, the getter returns that input")
    fun `When init to valid value, the variable equals the input`() {
        val p = Proportion(0.5)
        assertEquals(0.5, p.value)
    }

    @Test
    @DisplayName("When delegated variable is set with valid value, the getter returns that value")
    fun `When set to valid value, the variable equals the input`() {
        val p = Proportion(0.5)
        p.value = 0.6
        assertEquals(0.6, p.value)
    }

    @Test
    @DisplayName("When two proportions are checked for equality, it returns true if the proportion values are equal.")
    fun `When two proportions are checked for equality, it returns true only when the proportion values are equal`() {
        val prop1 = Proportion(0.5)
        val prop2 = Proportion(0.5)
        assertEquals(prop1, prop2)
    }

    @Test
    @DisplayName("When two proportions are checked for equality, it returns false if the proportion values are not equal.")
    fun `When two proportions are checked for equality, it returns false if the proportion values are not equal`() {
        val prop1 = Proportion(0.5)
        val prop2 = Proportion(0.6)
        assertNotEquals(prop1, prop2)
    }

    @Test
    @DisplayName("When delegated variable is initialized to invalid value, an error is thrown")
    fun `When init to invalid value, an error is thrown`() {
        assertThrows<Proportion.InvalidProportionValueException> {
            Proportion(-0.5)
        }
    }

    @Test
    @DisplayName("When delegated variable is set to invalid value, an error is thrown")
    fun `When valid init is set to invalid value, an error is thrown`() {
        val p = Proportion(0.5)
        assertThrows<Proportion.InvalidProportionValueException> {
            p.value = -0.5
        }
    }

}