package com.steamtechs.core.interactors

import com.steamtechs.core.domain.Proportion
import com.steamtechs.core.domain.Valve
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class UpdateValveProportionTest{
    lateinit var testValve: Valve
    val testProp = Proportion(0.23)


    @Test
    @DisplayName("Update Valve")
    fun `Update Valve`(){
        testValve = Valve(0.58)
        val valveUpdater = UpdateValveProportion()
        valveUpdater(testValve,testProp)
        assertEquals(testProp.prop, testValve.proportionOpen)
    }


}