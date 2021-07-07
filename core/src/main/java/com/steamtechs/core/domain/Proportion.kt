package com.steamtechs.core.domain

import java.lang.module.InvalidModuleDescriptorException
import kotlin.reflect.KProperty

class Proportion(var prop: Double) {

    init { throwIfInvalidValue(prop) }

    private fun throwIfInvalidValue(p: Double) {
        if (p < 0.0 || p > 1.0) throw InvalidProportionValueException("Proportion value must be between 0.0 and 1.0 inclusive.")
    }

    operator fun getValue(thisRef: Double?, property: KProperty<*>) = prop

    operator fun setValue(thisRef: Double?, property: KProperty<*>, value: Double) {
        throwIfInvalidValue(value)
        prop = value
    }

    class InvalidProportionValueException(message: String) : Exception(message)
}