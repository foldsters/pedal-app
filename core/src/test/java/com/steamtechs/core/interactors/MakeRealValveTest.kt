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

        @Test
        @DisplayName("add a RealValve to pre-populated ValveLog.")
        fun `add a RealValve to pre-populated ValveLog`() {
            val realValve1 = RealValve(Valve(Proportion(0.23)), ValveInfo())
            val realValve2 = RealValve(Valve(Proportion(0.345)), ValveInfo())
            val realValve3 = RealValve(Valve(Proportion(0.987)), ValveInfo())

            valveLog.addValve(realValve1)
            valveLog.addValve(realValve2)
            valveLog.addValve(realValve3)


            assertEquals(3, MakeRealValve(valveLog))
        }



    }



}