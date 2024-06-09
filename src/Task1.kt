package com.example.myapplication2

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class InvalidSpecialCharacterException(s: String) : Exception(s)
class InvalidNumberException(s: String) : Exception(s)
class InvalidLengthException(s: String) : Exception(s)
class InvalidUsernameException(s: String) : Exception(s)


fun main() = runBlocking {
    launch {
        val num = getNthFibonacci(5)
        println(num)
    }
    print("Result: ")
}

fun getNthFibonacci(nth: Int): Int {
    val nthIndex = nth - 1
    val fibonacci = arrayListOf(0, 1)
    for (i in 1..<nthIndex) {
        fibonacci.add(fibonacci[i] + fibonacci[i - 1])
    }
    return fibonacci[nthIndex]
}
