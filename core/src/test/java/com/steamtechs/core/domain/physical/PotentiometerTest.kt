package com.steamtechs.core.domain.physical

import com.steamtechs.core.domain.intangible.Proportion
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PotentiometerTest{

    lateinit var testPotentiometer: Potentiometer


    //Instance Creation Passes/Fails
    @ParameterizedTest
    @ValueSource(doubles = doubleArrayOf(0.0, 0.45, 1.0))
    @DisplayName("Create a new Potentiometer.")
    fun `Create a new Potentiometer`(testArmatureProportion: Double){
        testPotentiometer = Potentiometer(testArmatureProportion)
        assertInstanceOf(Potentiometer::class.java, testPotentiometer)
    }

    @ParameterizedTest
    @ValueSource(doubles = doubleArrayOf(-0.5, 3.0))
    @DisplayName("Instantiation fails when armatureProportion is outside interval [0,1]")
    fun `Instantiation fails when armatureProportion is outside interval 0,1`(testArmatureProportion: Double){
        assertThrows<Proportion.InvalidProportionValueException> {
            Potentiometer(testArmatureProportion)
        }
    }


    //Given proper instantiation
    @Nested
    @DisplayName("Given properly initiated Potentiometer, ")
    inner class  ProperlyInitializedPotentiometerTest{

        @BeforeEach
        private fun `Given properly initiated Potentiometer`(){
            testPotentiometer = Potentiometer(0.45)
        }


        //Show Getter
        @Test
        @DisplayName("get armatureProportion.")
        fun `get armatureProportion`(){
            assertEquals(0.45, testPotentiometer.armatureProportion)
        }

        //Show Setter Pass/Fail
        @Test
        @DisplayName("set armatureProportion passes.")
        fun `set armatureProportion passes`(){
            assertEquals(0.45, testPotentiometer.armatureProportion)
        }

        @Test
        @DisplayName("set armatureProportion fails with is outside interval [0, 1].")
        fun `set armatureProportion fails with is outside interval 0, 1`(){
            assertThrows<Proportion.InvalidProportionValueException> {
                testPotentiometer.armatureProportion = 3.4
            }
        }
    }





}