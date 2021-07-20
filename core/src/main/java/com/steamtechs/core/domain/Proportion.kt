package com.steamtechs.core.domain

import java.lang.module.InvalidModuleDescriptorException
import kotlin.reflect.KProperty

class Proportion(value: Double) {

    var value = value
        set(p) {
            throwIfInvalidValue(p)
            field = p
        }

    init { throwIfInvalidValue(value) }

    // Delegating classes require getValue and setValue methods to be defined with these arguments
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = this.value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        throwIfInvalidValue(value)
        this.value = value
    }

    private fun throwIfInvalidValue(p: Double) {
        if (p < 0.0 || p > 1.0) throw InvalidProportionValueException("Proportion value must be between 0.0 and 1.0 inclusive.")
    }

    fun verify(): Proportion {
        throwIfInvalidValue(value)
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Proportion || this.value != other.value) return false
        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    class InvalidProportionValueException(message: String) : Exception(message)
}