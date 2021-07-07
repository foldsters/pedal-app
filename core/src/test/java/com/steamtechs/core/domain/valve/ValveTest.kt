package com.steamtechs.core.domain.valve

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValveTest {

    private lateinit var testValve: Valve


    // Show when constructor passes

    @ParameterizedTest
    @ValueSource(doubles = doubleArrayOf(0.0, 0.45, 1.0))
    @DisplayName("Instance is of type Valve")
    fun `Instance is of type Valve`(testProportionOpen: Double) {
        testValve = Valve(testProportionOpen)
        assertInstanceOf(Valve::class.java, testValve)
    }


    // Show when constructor fails

    @ParameterizedTest
    @ValueSource(doubles = doubleArrayOf(-0.5, 3.0))
    @DisplayName("When proportionOpen is outside the interval [0, 1] constructor fails")
    fun `When proportionOpen is outside the interval 0, 1 constructor fails`(testPropOpen: Double)
        {
            assertThrows<IllegalArgumentException> {
                Valve(testPropOpen)
            }
    }


    // Show when getters and setters pass/fail

    @Nested
    @DisplayName("When Valve properly initialized")
    inner class ProperlyInitializedValveTest{

        @BeforeEach
        private fun `When instance is created`(){
            testValve = Valve(0.5)
        }


        // Show proportionOpen getters pass

        @Test
        @DisplayName("proportionOpen can be read with getter")
        fun `proportionOpen can be read with getter`(){
            assertEquals(0.5, testValve.proportionOpen)
        }


        // .. and setters pass/ fail

        @Test
        @DisplayName("proportionOpen can be updated with setter")
        fun `proportionOpen can be updated with setter`(){
            testValve.proportionOpen = 0.25
            assertEquals(0.25, testValve.proportionOpen)
        }


        @ParameterizedTest
        @ValueSource(doubles = doubleArrayOf(-0.5, 3.0))
        @DisplayName("Setting proportionOpen should be between 0 and 1 inclusive")
        fun `Setting proportionOpen should be between 0 and 1 inclusive`(proportion: Double){
            assertThrows<IllegalArgumentException> { testValve.proportionOpen = proportion }
        }

    }

}