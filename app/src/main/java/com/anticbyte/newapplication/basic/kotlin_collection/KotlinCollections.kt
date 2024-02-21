package com.anticbyte.newapplication.basic.kotlin_collection

fun main() {

    /*Array*/

    val firstNames = arrayOf("Imamul", "Afredi", "Kawser")
    val lastNames = arrayOf("Rana", "Rafi", "Raihan")

//    val fullNames = firstNames + lastNames
//    firstNames[0] = "Hg"
//    fullNames = arrayOf("Imamul", "Afredi", "Kawser","Rana", "Rafi", "Raihan")
//    println(fullNames[2])

//    val newArray = firstNames + lastNames

    /*List*/

//    val solarSystem = listOf("Saturn", "Earth", "Moon", "Uranus", "Venus")
//    for (planet in solarSystem) {
//        println(planet)
//    }

    /*Mutable List*/

//    val solarSystem =
//    mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem)
//    solarSystem.add("Theia")
//    solarSystem.removeAt(2)
//    println("Moon" in solarSystem)

    /*Sets*/

//    val nameSet = linkedSetOf("Rafi", "Rana", "Kawser","Rana")
//    println("Rafi".hashCode())
//    println(nameSet)

    /*Map*/

//    data class PersonDetails(
//        val firstName: String = "",
//        val lastName: String = "",
//        val age: Int = 0
//    )
//
//    val ranaDetails = PersonDetails("Imamul", "Rana", 25)
//    val rafiDetails = PersonDetails("Afredi", "Rafi", 25)
//
//
//    val personDetails = mutableMapOf<String, PersonDetails>(
//        "Imamul" to ranaDetails,
//        "Afredi" to rafiDetails
//    )
//
//    val ranaNewDetails = PersonDetails("Imamul Hasan", "Rana", 26)
//    personDetails["Imamul"] = ranaNewDetails
//
//    println(personDetails["Imamul"])


    fun compareTriplets(a: List<Int>, b: List<Int>): List<Int> {
        var alice = 0
        var bob = 0


        for (i in a.indices) {
            if (a[i] > b[i]) alice++
            else if (a[i] < b[i]) bob++
        }

        println(listOf(alice, bob))
        return listOf(alice, bob)
    }

//    compareTriplets(a = listOf(2, 3, 5).sum(), b = listOf(3, 5, 4))

//    compareTriplets(ar = arrayOf(2, 5, 6, 7))



}