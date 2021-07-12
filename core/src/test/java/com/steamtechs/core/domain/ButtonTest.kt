package com.steamtechs.core.domain

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class ButtonTest{

    lateinit var testButton:Button

    
    //Create Instance
    @Test
    @DisplayName("Create Instance of a Button")
    fun `Create Instance of a Button`(){
        testButton = Button(false)
        assertInstanceOf(Button::class.java, testButton)
    }

    @Nested
    @DisplayName("Given instance creation in 'OPEN' state, ")
    inner class OpenInstanceTest{

        @BeforeEach
        fun `Given instance creation in 'OPEN' state,`(){
            testButton = Button(true)
        }


        // Show getter
        @Test
        @DisplayName("get button state.")
        fun `get button state`(){
            assertEquals(true, testButton.circuitOpen)
        }

        // Show setter
        @Test
        @DisplayName("set button state to opposite.")
        fun `set button state to opposite`(){
            testButton.circuitOpen = testButton.circuitOpen.not()
            assertEquals(false, testButton.circuitOpen)
        }

    }
    
}