package com.steamtechs.core.domain.intangible

import kotlin.reflect.KProperty

class Proportion(var prop: Double) {

    init { throwIfInvalidValue(prop) }

    // Delegating classes require getValue and setValue methods to be defined with these arguments
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = prop

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        throwIfInvalidValue(value)
        prop = value
    }

    private fun throwIfInvalidValue(p: Double) {
        if (p < 0.0 || p > 1.0) throw InvalidProportionValueException("Proportion value must be between 0.0 and 1.0 inclusive.")
    }

    class InvalidProportionValueException(message: String) : Exception(message)
}