package com.steamtechs.core.domain.physical

import com.steamtechs.core.data.ValveInfo
import com.steamtechs.core.domain.intangible.Proportion
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class RealValveTest {

    lateinit var testRealValve : RealValve
    val testValve : Valve = Valve(Proportion(0.6))
    val testValveInfo : ValveInfo = ValveInfo()

    //Create Blank Instance
    @Test
    @DisplayName("Create Instance.")
    fun `Create Instance`() {
        testRealValve = RealValve(testValve, testValveInfo)
        assertInstanceOf(RealValve::class.java, testRealValve)
    }

    //With created instance:
    @Nested
    @DisplayName("Given instantiated instance,")
    inner class GivenInstantiatedRealValve() {

        @BeforeEach
        fun `Create RealValveInstance`() {
            testRealValve = RealValve(testValve, testValveInfo)
        }

        // Show getters on instance

        @Test
        @DisplayName("get dynamicValve from Instance.")
        fun `get dynamicValve from Instance`() {
            assertEquals(testValve, testRealValve.dynamicValve)

        }

        @Test
        @DisplayName("get valveInfo from Instance.")
        fun `get valveInfo from Instance`() {
            assertEquals(testValveInfo, testRealValve.valveInfo)

        }

        // Show properties of the attributes can be updated when appropriate

        @Test
        @DisplayName("update dynamicValve proportion.")
        fun `update dynamicValve proportion`() {
            testRealValve.dynamicValve.proportionOpen.value = 0.9
            assertEquals(0.9, testRealValve.dynamicValve.proportionOpen.value)
        }

        @Test
        @DisplayName("update valveInfo manufacturer.")
        fun `update valveInfo manufacturer`() {
            testRealValve.valveInfo.manufacturer = "Bob's Happy Valves"
            assertEquals("Bob's Happy Valves", testRealValve.valveInfo.manufacturer)
        }


    }


}