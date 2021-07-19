package com.steamtechs.core.interactors

import com.steamtechs.core.domain.Proportion
import com.steamtechs.core.domain.Valve

class UpdateValveProportion {
    operator fun invoke(valve: Valve, proportion: Proportion) {
        valve.proportionOpen = proportion.prop
    }
}