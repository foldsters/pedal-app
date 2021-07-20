package com.steamtechs.core.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ValvePresetTest{

    lateinit var testValvePreset: ValvePreset
    lateinit var valve1: Valve

    lateinit var valve2: Valve
    lateinit var valve3: Valve

    //Create instance
    @Test
    @DisplayName("Create new ValvePreset.")
    fun `Create new ValvePreset`(){
        val valve1 = Valve(0.5)
        testValvePreset = ValvePreset(mapOf(valve1 to Proportion(0.4)))
        assertInstanceOf(ValvePreset::class.java, testValvePreset)
    }

    //Given properly initialized ValvePreset
    @Nested
    @DisplayName("Given properly initiated Valve Preset, ")
    inner class ProperlyInitializedValvePresetTest {

        @BeforeEach
        private fun `Given properly initiated ValvePreset`() {
            valve1 = Valve(0.5)
            testValvePreset = ValvePreset(mapOf(valve1 to Proportion(0.4)))
        }

        //Show Getter
        @Test
        @DisplayName("get presetMap.")
        fun `get presetMap`(){
            assertEquals(mapOf(valve1 to 0.4), testValvePreset.presetMap)
        }

        //Show Setter Pass/Fail
        @Test
        @DisplayName("update presetMap succeeds.")
        fun `update presetMap succeeds`(){
            val updateMap = mapOf(valve1 to Proportion(0.3))
            testValvePreset.presetMap = updateMap
            assertEquals(updateMap, testValvePreset.presetMap)
        }

//        @Test
//        @DisplayName("update presetMap fails.")
//        fun `update presetMap fails`(){
//            val updateMap = mapOf(valve1 to Proportion(3.4))
//            testValvePreset.presetMap = updateMap
//            assert(updateMap, testValvePreset.presetMap)
//        }
    }



}

