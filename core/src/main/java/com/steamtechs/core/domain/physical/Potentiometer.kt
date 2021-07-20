package com.steamtechs.core.domain.physical

import com.steamtechs.core.domain.intangible.Proportion

class Potentiometer(armatureProportion: Double) {

    var armatureProportion : Double by Proportion(armatureProportion)

}