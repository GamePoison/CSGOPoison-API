package com.csgopoison.usercmd

import com.csgopoison.CSGOState.csgo
import com.csgopoison.Console.log
import org.gamepoison.every
import org.gamepoison.native.Pointer

const val globalVarsMemorySize = 64L

class GlobalVars {
    var initialized = false
    var mem = Pointer(0)

    val realTime = 0F
    val frameCount = 0
    val absoluteFrameTime = 0F
    val absoluteFrameStartTimeSTDDev = 0F
    val curTime get() = get_curTime()
    val frameTime = 0F
    val maxClients = 0
    val tickCount get() = get_tickCount()
    val intervalPerTick get() = get_intervalPerTick()
    val interpolationAmount = 0F
    val simTicksThisFrame = 0
    val networkProtocol = 0

    val bClient = false
    val nTimestampNetworkingBase = 0
    val nTimestampRandomizeWindow = 0

    init {
        log(1, "GlobalVars initialized")

        every(1, {
            val mem = Pointer.allocate(globalVarsMemorySize)

            try {
                if (csgo.process.source(csgo.engineModule.address + csgo.engineOffsets.dwGlobalVars, globalVarsMemorySize, mem)) {
                    csgo.globalVars.mem = mem

                    initialized = true
                }
            } catch (e: Exception) {
                println(e.printStackTrace())
            }

            return@every
        })
    }

    private fun get_curTime(): Double {
        return mem.float(0x10).toDouble()
    }

    private fun get_tickCount(): Int {
        return mem.int(0x1C)
    }

    private fun get_intervalPerTick(): Double {
        return mem.float(0x20).toDouble()
    }
}