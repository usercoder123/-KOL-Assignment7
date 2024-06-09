import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.collect  //Have to manually import this for collect() to work

fun main() = runBlocking<Unit> {
    for (i in 0..10) {
        launch {
            print("Input parameter $i: ")
        }
        sumToN(i).collect { value -> println(value) }
    }
}

fun sumToN(n: Int): Flow<Int> = flow {
    var sum = 0
    for (i in 0..n) {
        sum += i
    }
    delay(500)
    emit(sum)
}