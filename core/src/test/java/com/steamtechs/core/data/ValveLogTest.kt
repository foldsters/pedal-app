package com.steamtechs.core.data

import com.steamtechs.core.domain.intangible.Proportion
import com.steamtechs.core.domain.physical.RealValve
import com.steamtechs.core.domain.physical.Valve
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.security.InvalidKeyException

internal class ValveLogTest{


    @Test
    @DisplayName("Create ValveLog instance")
    fun `Create ValveLog instance`(){
        val testValveLog = ValveLog()
        assertInstanceOf(ValveLog::class.java, testValveLog)
    }


    @Nested
    @DisplayName("Given instantiated ValveLog, ")
    inner class GivenValveLogInstance{

        lateinit var testValveLog : ValveLog
        val valve1 = RealValve(Valve(Proportion(0.1)), ValveInfo())
        val valve2 = RealValve(Valve(Proportion(0.45)), ValveInfo())

        @BeforeEach
        fun `Create ValveLog Instance`(){
            testValveLog = ValveLog()
        }


        //Return length
        @Test
        @DisplayName("empty log returns length zero.")
        fun `empty log returns length zero`(){
            val testValveLog = ValveLog()
            assertEquals(0, testValveLog.length)
        }

        @Test
        @DisplayName("populated log returns length.")
        fun `populated log returns length`(){
            testValveLog = ValveLog()
            testValveLog.addValve(valve1)
            testValveLog.addValve(valve2)
            assertEquals(2, testValveLog.length)

        }

        //Add Valve
        @Test
        @DisplayName("add valve to log.")
        fun `add valve to log`(){
            testValveLog = ValveLog()
            val valveId : Int = testValveLog.addValve(valve1)
            assertEquals(valve1, testValveLog.getValve(valveId))
        }


        @Test
        @DisplayName("can't Add Valve to log that already contains it.")
        fun `can't Add Valve to log that already contains it`() {
            testValveLog = ValveLog()
            testValveLog.addValve(valve1)
            assertThrows<InvalidKeyException> {
                testValveLog.addValve(valve1)
            }
        }

        @Test
        @DisplayName("Two added valves do not have same ID")
        fun `Two added valves do not have same ID`(){
            val valveID1 : Int = testValveLog.addValve(valve1)
            val valveID2 : Int = testValveLog.addValve(valve2)
            assertNotEquals(valveID1, valveID2)
        }
        
        //Checks to see if an ID is contained in the valveLog
        
        @Test
        @DisplayName("can check if it contains an ID.")
        fun `can check if it contains an ID`() {
            val valveID1 : Int = testValveLog.addValve(valve1)
            assertEquals(true, testValveLog.containsID(valveID1))
        }

        @Test
        @DisplayName("can check if it doesn't contain an ID.")
        fun `can check if it doesn't contain an ID`() {
            assertEquals(false, testValveLog.containsID(-1))
        }

        // With valves in the valve log

        @Nested
        @DisplayName("populated with two valves, ")
        inner class GivenPopulatedValveLog{
            private var valveID1 : Int = 0
            private var valveID2 : Int = 0

            @BeforeEach
            fun `populate ValveLog`(){
                valveID1 = testValveLog.addValve(valve1)
                valveID2 = testValveLog.addValve(valve2)
            }


            //Return Valve by ID
            @Test
            @DisplayName("get the first valve by ID.")
            fun `get the first valve by ID`(){
                assertEquals(valve1,testValveLog.getValve(valveID1))
            }

            //Remove Valve by ID
            @Test
            @DisplayName("removing a valve that doesn't exist throws an error.")
            fun `removing a valve that doesn't exist throws an error`(){

                assertThrows<InvalidKeyException> {
                    testValveLog.removeValve(42)
                }
            }

            @Test
            @DisplayName("removing a valve decrements length.")
            fun `removing a valve decrements length`(){
                val oldLength = testValveLog.length
                testValveLog.removeValve(valveID1)
                assertEquals(oldLength - 1, testValveLog.length)
            }

            @Test
            @DisplayName("removed valve shouldn't be gettable.")
            fun `removed valve shouldn't be gettable`(){
                testValveLog.removeValve(valveID1)
                assertThrows<InvalidKeyException> {
                    testValveLog.getValve(valveID1)
                }
            }

            @Test
            @DisplayName("valveID should never be returned more than once.")
            fun `valveID should never be returned more than once`() {
                testValveLog.removeValve(valveID1)
                val valveID3 = testValveLog.addValve(RealValve(Valve(Proportion(0.0)), ValveInfo()))
                assertAll(
                    { assertNotEquals(valveID1, valveID3) },
                    { assertNotEquals(valveID2, valveID3) }
                )
            }

        }
    }
}