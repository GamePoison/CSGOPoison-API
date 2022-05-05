package com.csgopoison.usercmd

import com.csgopoison.CSGOState.csgo
import com.csgopoison.Console.log
import com.csgopoison.Vector
import org.gamepoison.every
import org.gamepoison.native.Pointer

const val dwInputMemorySize = 253L

class DwInput {
    var initialized = false
    var mem = Pointer(0)

    val bTrackIRAvailable = false
    var bMouseInitialized = false
    var bMouseActive = false
    var bJoystickAdvancedInit = false
    var bCameraInterceptingMouse = false
    var bCameraInThirdPerson = false
    var bCameraMovingWithMouse = false
    val vecCameraOffset = Vector()
    val bCameraDistanceMove = false
    val nCameraOldX = 0
    val nCameraOldY = 0
    val nCameraX = 0
    var nCameraY = 0
    val bCameraIsOrthographic = false
    val vecPreviousViewAngles = Vector()
    val vecPreviousViewAnglesTilt = Vector()
    val flLastForwardMove = 0F
    val nClearInputState = 0
    val pCommands get() = get_pCommands()
    val pVerifiedCommands get() = get_pVerifiedCommands()

    init {
        log(1, "DwInput initialized")

        every(5, { context ->
            val mem = Pointer.allocate(dwInputMemorySize) //TODO should we allocate...

            try {
                if (csgo.process.source(csgo.clientModule.offset(csgo.clientOffsets.dwInputSig), dwInputMemorySize, mem)) {
                    csgo.dwInput.mem = mem

                    initialized = true
                } else {
                    log(1, "Couldn't initialize DwInput")
                }
            } catch (e: Exception) {
                println(e.printStackTrace())
            }

            return@every
        })
    }

    private fun get_pCommands(): Int {
        return mem.int(0xF4)
    }

    private fun get_pVerifiedCommands(): Int {
        return mem.int(0xF8)
    }
}