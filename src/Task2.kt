import com.example.myapplication2.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    print("Enter username: ")
    val username = readlnOrNull()
//    println(isUsernameValid("Abcde@123"))
    println("Username valid ? " + username?.let { isUsernameValid(it) })
}

fun isUsernameValid(s: String): Boolean = runBlocking {
    val charList = s.toCharArray().map { it.toString() }

    launch {
        charList.forEach {
            if (it in "0".."9") {
                throw InvalidNumberException("Invalid number")
            }
        }
    }

    launch {
        val chars = "!@#\$%^&*()_".toCharArray().map { it.toString() }
        charList.forEach {
            if (chars.contains(it)) {
                throw InvalidSpecialCharacterException("Invalid special character")
            }
        }
    }

    launch {
        if (charList.size <= 4) {
            throw InvalidLengthException("Invalid length! Length must be greater than 4")
        }
    }

    if (s.length > 16) {
        throw InvalidUsernameException("Invalid username! Length must be 16 at max.")
    } else if (charList.any { it.matches("^[A-Z]".toRegex()) }) {
        throw InvalidUsernameException("Invalid username! Username must not contain any uppercase letter")
    }

    return@runBlocking true
}
