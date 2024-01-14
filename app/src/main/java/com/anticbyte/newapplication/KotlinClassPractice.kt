package com.anticbyte.newapplication

class Computer {
    val gameName = "GTA V"
    fun playGame() {
        println("playing game")
    }

}


fun main() {
    val computer = Computer()



    println(computer.gameName)
    computer.playGame()
}