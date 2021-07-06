package com.steamtechs.core.domain

class Valve(val id: Int, proportionOpen: Double) {

    var proportionOpen = proportionOpen
      set(value) {
          field = value
          proportionOpenBoundsCheck()
      }

    init {
        idBoundsCheck()
        proportionOpenBoundsCheck()
    }

    private fun idBoundsCheck() {
        if (id < 0) {
            throw IllegalArgumentException("id must be Non-Negative")
        }
    }

    private fun proportionOpenBoundsCheck(){
        if (proportionOpen > 1.0 || proportionOpen < 0.0) {
            throw IllegalArgumentException("proportionOpen needs to be between 0.0 and 1.0 inclusive.")
        }
    }


}