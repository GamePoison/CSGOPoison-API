package com.csgopoison

import com.csgopoison.CSGOState.csgo
import org.gamepoison.native.Pointer

typealias ClientState = Long

fun ClientState.angle(): Vector {
    val vec = Vector().apply {
        x = (csgo.process.float(csgo.process.offset(this@angle + csgo.engineOffsets.dwViewAngles))).toDouble()
        y = (csgo.process.float(csgo.process.offset(this@angle + csgo.engineOffsets.dwViewAngles) + 4)).toDouble()
        z = (csgo.process.float(csgo.process.offset(this@angle + csgo.engineOffsets.dwViewAngles) + 8)).toDouble()
    }

    return vec
}

fun ClientState.setAngle(newAngle: Vector) {
    newAngle.normalizeAngle()

    if (newAngle.z != 0.0) {
        println("bruh z isnt 0 wtfwtfwtf")
    }

    newAngle.z = 0.0

    csgo.process[this + csgo.engineOffsets.dwViewAngles] = newAngle.x.toFloat() //Pitch
    csgo.process[this + csgo.engineOffsets.dwViewAngles + 4] = newAngle.y.toFloat() //Yaw
    //Fuck the roll
}