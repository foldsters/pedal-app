package com.steamtechs.core.domain.physical

import com.steamtechs.core.domain.intangible.Proportion

class Valve(proportionOpen: Double) {

    var proportionOpen : Double by Proportion(proportionOpen)

}