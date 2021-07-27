package com.steamtechs.core.data

import com.steamtechs.core.domain.intangible.ValvesPreset
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.security.InvalidKeyException

internal class ValvesPresetLogTest{

    @Test
    @DisplayName("Create instance of ValvesPresetLog.")
    fun `Create instance of ValvesPresetLog`() {
        assertInstanceOf(ValvesPresetLog::class.java, ValvesPresetLog())
    }


    @Nested
    @DisplayName("Given Blank ValvesPresetLog, ")
    inner class GivenValvesPresetLogInstance{
        lateinit var testValvesPresetLog : ValvesPresetLog

        @BeforeEach
        fun `Given Given Blank ValvesPresetLog`(){
            testValvesPresetLog = ValvesPresetLog()
        }

        @Test
        @DisplayName("getter throws InvalidKeyException for unlogged ValvesPresetID.")
        fun `getter throws InvalidKeyException for unlogged ValvesPresetID`() {
            assertThrows<InvalidKeyException> {
                testValvesPresetLog.getValvesPreset(0)
            }
        }


        @Test
        @DisplayName("add ValvesPreset to log.")
        fun `add ValvesPreset to log`() {
            val testValvesPreset0 = ValvesPreset()
            assertEquals(0,testValvesPresetLog.addValvesPreset(testValvesPreset0))
        }

        @Nested
        @DisplayName("Given populated with one ValvesPreset, ")
        inner class GivenPopulatedValvesPresetLog{
            var testValvesPreset0 = ValvesPreset()
            var testValvesPreset1 = ValvesPreset()

            @BeforeEach
            fun `Given populated with one ValvesPreset`(){
                testValvesPresetLog.addValvesPreset(testValvesPreset0)
            }

            @Test
            @DisplayName("get ValvesPreset by id.")
            fun `get ValvesPreset by id`() {
                assertEquals(testValvesPreset0, testValvesPresetLog.getValvesPreset(0))
            }


            @Test
            @DisplayName("remove ValvesPreset by id.")
            fun `remove ValvesPreset by id`() {
                testValvesPresetLog.removeValvesPreset(0)
                assertThrows<InvalidKeyException> {
                    testValvesPresetLog.getValvesPreset(0)
                }
            }

            @Test
            @DisplayName("throws exception when attempting to remove unlogged valvesPresetID.")
            fun `throws exception when attempting to remove unlogged valvesPresetID`() {
                assertThrows<InvalidKeyException> {
                    testValvesPresetLog.removeValvesPreset(32)
                }
            }


            @Test
            @DisplayName("remove and re-add ValvesPreset showing it receives a unique valvesPresetID.")
            fun `remove and re-add ValvesPreset showing it receives a unique valvesPresetID`() {
                testValvesPresetLog.removeValvesPreset(0)
                assertNotEquals(0, testValvesPresetLog.addValvesPreset(testValvesPreset0))
            }
        }

    }


}