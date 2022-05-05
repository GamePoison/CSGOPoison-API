package com.csgopoison

import java.io.File
import java.time.LocalDateTime

enum class Priority(val num: Int) {
    PRIORITY_1(1),
    PRIORITY_2(2),
    PRIORITY_3(3),
    PRIORITY_4(4),
    PRIORITY_5(5);

    companion object {
        fun fromInt(value: Int) = values().first { it.num == value }
    }
}

object Console {
    //GamePoison_Internal
    val consoleLogFile = "app//console.txt"

    val consoleBuffer = StringBuilder()
    private val consoleBackBuffer = importBackBufferFromFile(consoleLogFile)

    private val consoleUpdateRateMS = 100L

    private val msg = StringBuilder()
    fun log(pri: Int = 4, str: String) {
        val computerTime = LocalDateTime.now()
        val localTime = "${computerTime.dayOfMonth}:${computerTime.month}:${computerTime.year} ${computerTime.hour}:${computerTime.minute}:${computerTime.second}"

        msg.clear()

        if (pri in 1..4) {
            msg.append("\n$localTime").append(" $str")
            consoleBuffer.appendLine(msg)
            println(msg)
        } else {
            println(msg)
        }
    }

    fun importBackBufferFromFile(fileString: String, initLineCount: Int = 20): List<String> {
        val alloc = arrayListOf<String>()

        val file = File(fileString)

        val lines = file.readLines()
        val len = lines.count()

        val sliced: MutableList<String> = if (len > 256) {
            lines.subList(len - (initLineCount + 1), len).toMutableList()
        } else {
            lines.toMutableList()
        }

        alloc.addAll(sliced)

        sliced.clear()

        return alloc
    }

}