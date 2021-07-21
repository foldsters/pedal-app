package com.steamtechs.core.interactors

import com.steamtechs.core.data.ValveInfo
import com.steamtechs.core.data.ValveLog
import com.steamtechs.core.domain.intangible.Proportion
import com.steamtechs.core.domain.physical.RealValve
import com.steamtechs.core.domain.physical.Valve
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class MakeRealValveTest {

    lateinit var valveLog : ValveLog

    //Show Instance Creation
    @Test
    @DisplayName("Make instance of MakeRealValve.")
    fun `Make instance of MakeRealValve`() {
        assertInstanceOf(MakeRealValve::class.java, MakeRealValve)
    }


    //Provide a ValveLog
    @Nested
    @DisplayName("Given a MakeRealValve Instance, ")
    inner class GivenRealValveInstance{

        @BeforeEach
        fun `Given a RealValve Instance`(){
            valveLog = ValveLog()
        }

        //Show class usage
        @Test
        @DisplayName("add it to the ValveLog and return valveID.")
        fun `add it to the ValveLog and return valveID`() {
            assertEquals(0,MakeRealValve(valveLog))
        }



    }



}