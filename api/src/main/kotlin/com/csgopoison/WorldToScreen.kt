package com.csgopoison

import com.csgopoison.CSGOState.csgo
import com.sun.jna.Memory
import org.gamepoison.native.Pointer

//TODO class it up

private val csgoViewMatrix = Array(4) { DoubleArray(4) }

fun worldToScreen(fromX: Double, fromY: Double, fromZ: Double, vOut: Vector): Vector {
    refreshCsgoViewMatrix()

    vOut.x = (csgoViewMatrix[0][0] * fromX + csgoViewMatrix[0][1] * fromY + csgoViewMatrix[0][2] * fromZ + csgoViewMatrix[0][3])
    vOut.y = (csgoViewMatrix[1][0] * fromX + csgoViewMatrix[1][1] * fromY + csgoViewMatrix[1][2] * fromZ + csgoViewMatrix[1][3])
    val depth = (csgoViewMatrix[3][0] * fromX + csgoViewMatrix[3][1] * fromY + csgoViewMatrix[3][2] * fromZ + csgoViewMatrix[3][3])

    val width = csgo.csgoWidth
    val height = csgo.csgoHeight
    var xx = width / 2.0
    var yy = height / 2.0

    val notNan = !depth.isNaN()

    if (notNan && depth >= 0.01) { //In front
        val invDepth = 1.0 / depth

        vOut.x *= invDepth
        vOut.y *= invDepth

        xx += 0.5 * vOut.x * width + 0.5
        yy -= 0.5 * vOut.y * height + 0.5

        vOut.x = xx
        vOut.y = yy
        vOut.z = 1.0
    } else if (notNan &&  depth < 0.01) {
        val invDepth = -1.0 / depth

        vOut.x *= invDepth
        vOut.y *= invDepth

        xx += 0.5 * vOut.x * width + 0.5
        yy -= 0.5 * vOut.y * height + 0.5

        vOut.x = xx
        vOut.y = yy
        vOut.z = -1.0
    }

    return vOut
}

fun worldToScreen(from: Vector): Vector {
    val vec = Vector()
    worldToScreen(from.x, from.y, from.z, vec)
    return vec
}

fun refreshCsgoViewMatrix(): Boolean {
    val data = Pointer.allocate(64)

    try {
        val floatArray = FloatArray(16)
        if (!csgo.process.source(csgo.clientModule.offset(csgo.clientOffsets.dwViewMatrix), 64, data)) {
            return false
        }

        data.getFloatArray(0,  16, floatArray)

        if (floatArray.all(Float::isFinite)) {
            var offset = 0
            for (row in 0..3) for (col in 0..3) {
                val value = floatArray[offset]//data.float(offset.toLong())
                csgoViewMatrix[row][col] = value.toDouble()
                offset++ //Changed, error but not compd
            }
        }

        return true
    } finally {
        data.release(64)
    }
}
//
fun Pointer.getFloatArray(offset: Long, arraySize: Int, floatArray: FloatArray): FloatArray {
    for (i in 0 until  arraySize) {
        floatArray[i] = float(offset+(4*i))
    }

    return floatArray
}
