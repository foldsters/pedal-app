package com.steamtechs.core.domain

class Potentiometer(armatureProportion: Double) {

    var armatureProportion = armatureProportion
        set(value) {
            field = value
            armatureProportionBoundsCheck()
        }

    init {
        armatureProportionBoundsCheck()
    }


    private fun armatureProportionBoundsCheck(){
        if (armatureProportion > 1.0 || armatureProportion < 0.0) {
            throw IllegalArgumentException("armatureProportion needs to be between 0.0 and 1.0 inclusive.")
        }
    }

}