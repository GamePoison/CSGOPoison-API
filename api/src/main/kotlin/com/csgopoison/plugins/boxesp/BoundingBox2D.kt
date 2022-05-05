package com.csgopoison.plugins.boxesp

data class BoundingBox2D(var left: Double = -1.0, var right: Double = -1.0, var top: Double = -1.0, var bottom: Double = -1.0) {
    fun set(left: Double, right: Double, top: Double, bottom: Double) = this.run { this.left = left; this.right = right; this.top = top; this.bottom = bottom; }

    fun reset() = this.run { this.left = -1.0; this.right = 1.0; this.top = -1.0; this.bottom = -1.0; }
}

fun BoundingBox2D.width(): Float {
    return (this.right - this.left).toFloat()
}

fun BoundingBox2D.height(): Float {
    return (this.bottom - this.top).toFloat()
}