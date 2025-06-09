package icu.azusachino.kanna.clazz

/**
 *
 * @author haru
 * @date 2025/06/09 18:02
 */
fun main() {
    println("SyntaxDemo")
    myLet("Hello") {
        println(it)
    }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumSimple(a: Int, b: Int) = a + b

inline fun <T> myLet(value: T, block: (T) -> Unit) {
    println("before")
    block(value)
    println("after")
}

open class Shape {
}

class Rectangle(private val height: Double, private val length: Double) : Shape() {
    private val perimeter = (height + length) * 2
    private val area = height * length
    fun printInfo() {
        println("Rectangle: height = $height, length = $length, perimeter = $perimeter, area = $area")
    }
}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }

fun rangeDemo() {
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }

    val list = listOf("a", "b", "c")

    val cond = -1 !in 0..list.lastIndex;
    if (cond) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    for (x in 1..10 step 2) {
        print(x)
    }
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}