package com.steamtechs.core.domain

class Valve(proportionOpen: Proportion) {

    var proportionOpen = proportionOpen.verify()

}