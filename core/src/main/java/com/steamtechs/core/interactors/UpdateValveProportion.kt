package com.steamtechs.core.interactors

import com.steamtechs.core.domain.intangible.Proportion
import com.steamtechs.core.domain.physical.Valve

class UpdateValveProportion {
    operator fun invoke(valve: Valve, proportion: Proportion) {
        valve.proportionOpen = proportion.prop
    }
}