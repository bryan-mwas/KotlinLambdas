import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

val square = { number: Int -> number * number }
val noReturn: (String, Int) -> String = { str, int -> str + int }
val magnitude100String = { input: Int ->
    val magnitude = input * 100
    magnitude.toString()
}

// Returning from lambda
val calculateGrade: (Int) -> Any = { grade: Int ->
    when (grade) {
        in 0..40 -> "Fail"
        in 41..70 -> "Pass"
        in 71..100 -> "Distinction"
        else -> false
    }
}

val array = arrayOf(1, 2, 3, 4, 5)

fun invokeLambda(lambda: (Double) -> Boolean): Boolean {
    return lambda(3.14)
}

@Test
fun whenPassingALambdaObject_thenCallTriggerLambda() {
    val lambda = {
        arg: Double -> arg == 3.14
    }

    val result = invokeLambda(lambda)

    assertTrue(result)
}

fun main(args: Array<String>) {
    println(square(9))
    println(noReturn("Ninety ", 9))
    println(magnitude100String(9))
    println(calculateGrade(90))
    // it
    // Longhand version
    array.forEach { item: Int -> println(item * 4) }
    // shorthand version
    array.forEach { println(it * 4) }

    whenPassingALambdaObject_thenCallTriggerLambda()
}