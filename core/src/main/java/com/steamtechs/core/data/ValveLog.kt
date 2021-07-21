package com.steamtechs.core.data

import com.steamtechs.core.domain.physical.RealValve
import com.steamtechs.core.domain.physical.Valve
import java.security.InvalidKeyException

class ValveLog {

    var length: Int = 0
    private var idCounter : Int = 0

    private val valveMap : MutableMap<Int, RealValve> = mutableMapOf()

    fun addValve(realValve : RealValve) : Int {
        if (realValve in valveMap.values) {
            throw InvalidKeyException("Same instance of a realValve cannot be added to a valve log twice")
        }
        valveMap[idCounter] = realValve
        length++
        return idCounter++

    }

    fun getValve(valveId : Int): RealValve {
        return valveMap[valveId] ?: throw InvalidKeyException("ReaValve not in Valve Log")
    }

    fun removeValve(valveId: Int) {
        valveMap.remove(valveId) ?: throw InvalidKeyException("RealValve not in Valve Log")
        length--
    }


}