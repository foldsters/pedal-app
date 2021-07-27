package com.steamtechs.core.interactors

import com.steamtechs.core.data.ValveLog
import com.steamtechs.core.domain.intangible.Proportion
import com.steamtechs.core.domain.intangible.ValvesPreset

object MakeValvesPreset {
    operator fun invoke(valveLog: ValveLog) : ValvesPreset {
        val startProportion = Proportion(0.0)
        val workingPreset = ValvesPreset()
        for (key in valveLog.valveMap.keys) {
            workingPreset.valvesMap[key] = startProportion
        }
        return workingPreset
    }
}