package com.steamtechs.core.domain.physical

import com.steamtechs.core.domain.intangible.Proportion

class Valve(proportionOpen: Proportion) {

    var proportionOpen = proportionOpen.verify()

}