package com.steamtechs.core.data

import com.steamtechs.core.domain.intangible.ValvesPreset
import java.security.InvalidKeyException

class ValvesPresetLog : MutableMap<Int, ValvesPreset> {

    override val size: Int
        get() = entries.size


    override fun containsKey(key: Int): Boolean {
        if (key in keys){
            return true
        }
        return false
    }

    override fun containsValue(value: ValvesPreset): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: Int): ValvesPreset? {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override val entries: MutableSet<MutableMap.MutableEntry<Int, ValvesPreset>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<Int>
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<ValvesPreset>
        get() = TODO("Not yet implemented")

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun put(key: Int, value: ValvesPreset): ValvesPreset? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out Int, ValvesPreset>) {
        TODO("Not yet implemented")
    }

    override fun remove(key: Int): ValvesPreset? {
        TODO("Not yet implemented")
    }


//    private var valvesPresetMap = mutableMapOf<Int, ValvesPreset>()
//    private var idCounter : Int = 0
//
//
//    fun addValvesPreset(valvesPreset: ValvesPreset): Int {
//        valvesPresetMap[valvesPresetMap.size] = valvesPreset
//        idCounter++
//        return idCounter - 1
//    }
//
//
//
//    fun removeValvesPreset(valvesPresetID: Int) {
//        if (valvesPresetID in valvesPresetMap.keys) {
//            valvesPresetMap.remove(valvesPresetID)
//        }
//        else {
//            throw InvalidKeyException("Cannot remove ValvesPreset not in Log.")
//        }
//
//    }
//
//    fun getValvesPreset(valvesPresetID: Int): ValvesPreset? {
//        if (valvesPresetID !in valvesPresetMap.keys){
//            throw InvalidKeyException("ValvesPreset is not in Log.")
//        }
//        return valvesPresetMap[valvesPresetID]
//    }

}