package com.steamtechs.core.domain

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValveTest {

    private lateinit var testValve: Valve

    // Show constructor works

    @Test
    @DisplayName("Instance is of type Valve")
    fun `Instance is of type Valve`() {
        testValve = Valve(0, 0.5)
        assertInstanceOf(Valve::class.java, testValve)
    }

    // Show when constructor fails

    @Test
    @DisplayName("When id is negative constructor fails")
    fun `Valve constructor fails when id is negative`(){
        assertThrows<IllegalArgumentException> {
            Valve(-3, 0.5)
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = doubleArrayOf(-0.5, 3.0))
    @DisplayName("When proportionOpen is outside the interval [0, 1] constructor fails")
    fun `When proportionOpen is outside the interval 0, 1 constructor fails`(testPropOpen: Double) {
        assertThrows<IllegalArgumentException> {
            Valve(0, testPropOpen)
        }

    }

    // Show when getters and setters pass/fail

    @Nested
    @DisplayName("When Valve properly initialized")
    inner class ProperlyInitializedValveTest{

        @BeforeEach
        private fun `When instance is created`(){
            testValve = Valve(0, 0.5)
        }

        // Show id getters (setters unavailable for id param)
        @Test
        @DisplayName("id can be read with getter")
        fun `id can be read with getter`(){
            assertEquals(0, testValve.id)
        }

        // Show proportionOpen getters and setters
        @Test
        @DisplayName("proportionOpen can be read with getter")
        fun `proportionOpen can be read with getter`(){
            assertEquals(0.5, testValve.proportionOpen)
        }

        @ParameterizedTest
        @ValueSource(doubles = doubleArrayOf(-0.5, 3.0))
        @DisplayName("Setting proportionOpen should be between 0 and 1 inclusive")
        fun `Setting proportionOpen should be between 0 and 1 inclusive`(proportion: Double){
            assertThrows<IllegalArgumentException> { testValve.proportionOpen = proportion }
        }

    }

}