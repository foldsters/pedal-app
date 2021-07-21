package com.steamtechs.core.interactors

import com.steamtechs.core.data.ValveInfo
import com.steamtechs.core.data.ValveLog
import com.steamtechs.core.domain.intangible.Proportion
import com.steamtechs.core.domain.physical.RealValve
import com.steamtechs.core.domain.physical.Valve

object MakeRealValve {

    operator fun invoke(valveLog: ValveLog) : Int {
        val realValve = RealValve(Valve(Proportion(0.0)), ValveInfo())
        return valveLog.addValve(realValve)
    }

}