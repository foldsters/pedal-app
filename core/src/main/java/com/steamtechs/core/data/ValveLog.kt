package com.steamtechs.core.data

import com.steamtechs.core.domain.Valve
import java.security.InvalidKeyException

class ValveLog {

    var length: Int = 0
    private var idCounter : Int = 0

    private val valveMap : MutableMap<Int, Valve> = mutableMapOf()

    fun addValve(valve : Valve) : Int {
        if (valve in valveMap.values) {
            throw InvalidKeyException("Same instance of a valve cannot be added to a valve log twice")
        }
        valveMap[idCounter] = valve
        length++
        return idCounter++

    }

    fun getValve(valveId : Int): Valve {
        return valveMap[valveId] ?: throw InvalidKeyException("Valve not in Valve Log")
    }

    fun removeValve(valveId: Int) {
        valveMap.remove(valveId) ?: throw InvalidKeyException("Valve not in Valve Log")
        length--
    }


}