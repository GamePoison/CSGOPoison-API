package com.csgopoison

import kotlin.math.sqrt

//TODO convert to float?
data class Vector(var x: Double = 0.0, var y: Double = 0.0, var z: Double = 0.0) {
    fun set(x: Double, y: Double, z: Double) = apply {
        this.x = x
        this.y = y
        this.z = z
    }

    fun zeroOut() = apply {
        this.x = 0.0
        this.y = 0.0
        this.z = 0.0
    }

    fun isZero(): Boolean {
        return (this.x == 0.0 && this.y == 0.0 && this.z == 0.0)
    }

    fun dst2 (x: Double, y: Double, z: Double): Double {
        val a = x - this.x
        val b = y - this.y
        val c = z - this.z
        return a * a + b * b + c * c
    }

    fun dot(x: Double, y: Double, z: Double): Double {
        return this.x * x + this.y * y + this.z * z
    }

    fun set(x: Double, y: Double): Vector {
        this.x = x
        this.y = y
        return this
    }

    fun set(v: Vector) = apply{
        this.x = v.x
        this.y = v.y
        this.z = v.z
    }

    fun scl(x: Double, y: Double): Vector {
        this.x *= x
        this.y *= y
        return this
    }

    fun dot(v: Vector): Double {
        return this.x * v.x + this.y * v.y + this.z * v.z
    }

    fun len2(x: Double, y: Double, z: Double): Double {
        return x * x + y * y + z * z
    }

    fun nor(): Vector {
        val len2 = this.len2()
        return if (len2 == 0.0 || len2 == 1.0) this else scl(1f / sqrt(len2.toDouble()).toDouble())
    }

    fun sub(x: Double, y: Double, z: Double): Vector {
        return this.set(this.x - x, this.y - y, this.z - z)
    }

    fun len2(): Double {
        return x * x + y * y + z * z
    }

    operator fun plus(v: Vector): Vector {
        x += v.x
        y += v.y
        z += v.z
        return this
    }

    operator fun minus(v: Vector): Vector {
        x -= v.x
        y -= v.y
        z -= v.z
        return this
    }

    operator fun times(d: Double): Vector {
        x *= d
        y *= d
        z *= d
        return this
    }

    fun scl(value: Double): Vector {
        x *= value
        y *= value
        z *= value
        return this
    }

    fun normalizeAngle() = apply {
        if (x > 89.0) x = 89.0
        if (x < -89.0) x = -89.0

        while (y > 180.0) y -= 360.0
        while (y < -180.0) y += 360.0

        z = 0.0
    }

    fun lerp(to: Vector, T: Double) = apply {
        this + (to - this) * T
    }

    //shawty wanna fuck
    fun lerpAngle(to: Vector, T: Double) = apply {
        var deltaVec = to - this

        deltaVec.normalizeAngle()

        x += deltaVec.x * T
        y += deltaVec.y * T
        z = 0.0

        normalizeAngle()
    }
}