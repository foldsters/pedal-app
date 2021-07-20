package com.steamtechs.core.domain.physical

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class SwitchTest{

    lateinit var testSwitch : Switch

    
    //Create Instance
    @Test
    @DisplayName("Create Instance of a Switch")
    fun `Create Instance of a Switch`(){
        testSwitch = Switch(false)
        assertInstanceOf(Switch::class.java, testSwitch)
    }

    @Nested
    @DisplayName("Given instance creation in 'OPEN' state, ")
    inner class OpenInstanceTest{

        @BeforeEach
        fun `Given instance creation in 'OPEN' state,`(){
            testSwitch = Switch(true)
        }


        // Show getter
        @Test
        @DisplayName("get switch state.")
        fun `get switch state`(){
            assertEquals(true, testSwitch.circuitOpen)
        }

        // Show setter
        @Test
        @DisplayName("set switch state to opposite.")
        fun `set switch state to opposite`(){
            testSwitch.circuitOpen = testSwitch.circuitOpen.not()
            assertEquals(false, testSwitch.circuitOpen)
        }

    }
    
}