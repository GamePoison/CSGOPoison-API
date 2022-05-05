package com.csgopoison.plugins

import com.csgopoison.CSGOState.csgo

fun sendPackets(bool: Boolean) {
    val byte = if (bool) 1.toByte() else 0.toByte()
    //csgo.engineModule[0xD93D2] = byte

    csgo.process[csgo.entityManager.clientState + 0x114] = if (bool) 0F else 9999999F
}