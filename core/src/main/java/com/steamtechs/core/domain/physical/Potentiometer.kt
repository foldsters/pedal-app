package com.steamtechs.core.domain.physical

import com.steamtechs.core.domain.intangible.Proportion

class Potentiometer(armatureProportion: Proportion) {

    var armatureProportion = armatureProportion.verify()

}