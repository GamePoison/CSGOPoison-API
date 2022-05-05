package com.csgopoison.usercmd

import com.csgopoison.CSGOState.csgo
import com.csgopoison.Console
import com.csgopoison.Console.log
import com.csgopoison.Vector
import org.gamepoison.native.Pointer
import org.gamepoison.native.Source
import kotlin.io.path.Path
import kotlin.io.path.appendLines

class UserCMD(initMem: Pointer) {
    private var mem = initMem

    val pointer = 0
    var iCmdNumber = 0
    var iTickCount = 0
    var vecViewAngles = Vector()
    var vecAimDirection = Vector()
    var flForwardMove = 0F
    var flSideMove = 0F
    var flUpMove = 0F

    var iButtons
        get() = get_iButtons()
        set(value) { set_iButtons(value) }

    var bImpulse = 0
    var iWeaponSelect = 0
    var iWeaponSubtype = 0
    var iRandomSeed = 0
    var siMouseDx = 0
    var siMouseDy = 0
    val bHasBeenPredicted get() = get_bHasBeenPredicted()

    private fun get_iButtons(): Int {
        return mem.int(0x30)
    }
    private fun set_iButtons(value: Int): Boolean {
        return mem.set(0x30, value)
    }

    private fun get_bHasBeenPredicted(): Boolean {
        return mem.byte(0x48).toString().toBoolean()
    }

    fun writeToMemory(toPtr: Long): Boolean {
        return try {
            csgo.process.set(toPtr, mem, 100)
        } catch (e: Exception) {
            log(1, "UserCMD Write To Memory Error ${e.stackTraceToString()}")
            false
        }
    }
}