package com.steamtechs.core.domain

class Valve(proportionOpen: Double) {

    var proportionOpen : Double by Proportion(proportionOpen)

}