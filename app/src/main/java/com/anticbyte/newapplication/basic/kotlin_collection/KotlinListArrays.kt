package com.anticbyte.newapplication.basic.kotlin_collection

fun main() {
    val firstNames = arrayOf("Imamul", "Afredi", "Kawser")
    val lastNames = arrayOf("Rana", "Rafi", "Raihan")

    val fullNames = firstNames + lastNames
//    val newArray = fullNames.set(2, "Nabila")


//    fullNames = arrayOf("Imamul", "Afredi", "Kawser","Rana", "Rafi", "Raihan")

    println(fullNames[2])
}