package com.alie.modulepracticebaselearn.primary

/**
 * lamda表达式----> 匿名函数
 */
fun main(array: Array<String>) {


    val a = 5
    val b = 6

    // 使用1
    val num = calNum119(5, 6, { m, n -> m + n })
    println("num:${num}")
    // 使用2 函数中最后一个参数也是函数的时候 lamda表达式可以放在括号外边
    val num2 = calNum119(a, b) { m, n -> m + n }
    println("num2:${num2}")

    // 使用3
    val c = 9
    val num3 = calNumIncrease119(c) { it -> it * 6 }
    val num4 = calNumIncrease119(c) { it * 6 } // 函数参数中有高阶函数，并且高阶函数只有一个参数时，声明和->可以省略，直接写返回表达式
    println("num3:${num3}  num3:${num4}")

    //==========================================
//    calNumIncrease119Again(5,6,{a,b->a+b})
//    calNumIncrease119Again(5, 6) { a, b -> a + b }
    calNumIncrease119Again { a, b -> a + b }
}

fun calNum119(a: Int, b: Int, block: (Int, Int) -> Int): Int = block(a, b)

fun calNumIncrease119(a: Int, block: (Int) -> Int): Int = block(a)

fun calNumIncrease119Again(a: Int = 0, b: Int = 0, block: (Int, Int) -> Int): Int = block(a, b)