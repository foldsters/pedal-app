package com.steamtechs.core.data


class ValveInfo() : ComponentInfo {

    override var manufacturer: String? = null
        set(value) {
            nonEmptyStringCheck(value)
            field = allowedCharStringCheck(value)
        }
    override var supplier: String? = null
        set(value) {
            nonEmptyStringCheck(value)
            field = allowedCharStringCheck(value)
        }
    override var partNumber: String? = null
        set(value) {
            nonEmptyStringCheck(value)
            field = allowedCharStringCheck(value)
        }


    private fun nonEmptyStringCheck(checkString: String?) {
        if (checkString == "") {
            throw Exception()
        }
    }

    fun isSpecialCharacter(char: Char): Boolean {
        val unsupportedChars = listOf<Char>('{', '}', '$', '\\')
        if (char in unsupportedChars){ return false}
        return true
    }

    private fun allowedCharStringCheck(checkString: String?): String?{
        if (checkString != null) {
            val result = checkString.filter(::isSpecialCharacter)
            nonEmptyStringCheck(result)
            return result
        }
        return null
    }
}
