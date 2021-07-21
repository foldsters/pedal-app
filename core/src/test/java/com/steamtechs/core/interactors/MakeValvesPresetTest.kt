package com.steamtechs.core.interactors

import com.steamtechs.core.data.ValveInfo
import com.steamtechs.core.data.ValveLog
import com.steamtechs.core.domain.intangible.Proportion
import com.steamtechs.core.domain.intangible.ValvesPreset
import com.steamtechs.core.domain.physical.RealValve
import com.steamtechs.core.domain.physical.Valve
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MakeValvesPresetTest {

    lateinit var valveLog : ValveLog
    val blankValveInfo = ValveInfo()
    var valve1 = Valve(Proportion(0.324))
    val realValve1 = RealValve(valve1, blankValveInfo)
    var valve2 = Valve(Proportion(0.12983746))
    val realValve2 = RealValve(valve2, blankValveInfo)
    var valve3 = Valve(Proportion(0.97834))
    val realValve3 = RealValve(valve3, blankValveInfo)

    @Test
    @DisplayName("Return a ValvesPreset from valveLog.")
    fun `Return a ValvesPreset from valveLog`() {
        valveLog = ValveLog()
        valveLog.addValve(realValve1)
        valveLog.addValve(realValve2)
        valveLog.addValve(realValve3)
        assertInstanceOf(ValvesPreset::class.java,MakeValvesPreset(valveLog))
        print(MakeValvesPreset(valveLog).presetMap)
    }
}