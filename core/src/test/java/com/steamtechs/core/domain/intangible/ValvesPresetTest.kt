package com.steamtechs.core.domain.intangible

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ValvesPresetTest{

    //Create Instance
    @Test
    @DisplayName("Create instance of ValvesPreset.")
    fun `Create instance of ValvesPreset`() {
        assertInstanceOf(ValvesPreset::class.java, ValvesPreset())
    }

    @Nested
    @DisplayName("Given instance of ValvesPreset, ")
    inner class GivenValvesPresetInstance{
        lateinit var preset : ValvesPreset

        @BeforeEach
        fun `Given instance of ValvesPreset`(){
            preset = ValvesPreset()
        }

        @Test
        @DisplayName("getter returns MutableMap.")
        fun `getter returns MutableMap`() {
            assertInstanceOf(MutableMap::class.java, preset.valvesMap)
        }

        @Test
        @DisplayName("getter returns Blank Map before being updated.")
        fun `getter returns Blank Map before being updated`() {
            assertEquals(mutableMapOf<Int, Proportion>(), preset.valvesMap)
        }

        @Test
        @DisplayName("setter updates Entire presetMap.")
        fun `setter updates Entire presetMap`() {
            val newMap = mutableMapOf<Int, Proportion>(
                Pair(0, Proportion(0.3)), Pair(23, Proportion(0.32)),
                Pair(5, Proportion(0.6)), Pair(9, Proportion(0.9875))
            )
            preset.valvesMap = newMap
            assertEquals(newMap, preset.valvesMap)
        }
    }
}

