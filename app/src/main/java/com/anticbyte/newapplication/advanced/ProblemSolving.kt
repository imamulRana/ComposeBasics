package com.anticbyte.newapplication.advanced

fun gradingStudents(grades: Array<Int>): Array<Int> {

    for (grade in grades) {
        println(grades[grade])
    }
    return arrayOf()
}


fun main() {
    gradingStudents(arrayOf(14, 12))
}