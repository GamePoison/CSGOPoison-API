package com.csgopoison.input

import org.gamepoison.native.jna.windows.User32
import java.awt.Robot

class UserInput {
    val inputRobot = Robot()

    fun keyDown(vkCode: Int): Boolean {
        return (User32.GetKeyState(vkCode).toInt() < 0)
    }
}