package com.csgopoison.plugins.boxesp

enum class PosFlags(val value: Int) {
    UP(1), DOWN(2), LEFT(3), RIGHT(4);

    companion object {
        fun fromInt(value: Int) = values().first { it.value == value }
    }
}