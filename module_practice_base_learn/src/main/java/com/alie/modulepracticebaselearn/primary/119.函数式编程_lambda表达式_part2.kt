package com.alie.modulepracticebaselearn.primary

const val x = 56
const val y = 33

fun main(array: Array<String>) {

    //【举例：定义一个两个数相加的函数变量】
    //lambda演变1-完整的lambda表达式
    val block1: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    //lambda演变2.1-kotlin的自动推断在实现时可省略参数类型
    val block2_1: (Int, Int) -> Int = { x, y -> x + y }

    //lambda演变2.2-kotlin的自动推断在定义不写类型，但是实现的时候要写
    val block2_2 = { x: Int, y: Int -> x + y }

    //lambda演变3.1传参时-完整的写法
    part2CalNum1(x, y, { a: Int, b: Int -> a + b })

    //lambda演变3.2-传参时-最后一个参数是函数的时候，可以将此函数放到外边
    part2CalNum1(x, y) { a: Int, b: Int -> a + b }

    //lambda演变3.3-传参时-根据kotlin的自动推断，函参在实现时候，类型可省略
    part2CalNum1(x, y) { a, b -> a + b }

    //lambda演变3.3-传参时-根据kotlin的自动推断，函参在实现时候，类型可省略
    part2CalNum2("Hello") { a, b -> a + b }

    //lambda演变4传参时-函参只有一个参数，则在lambda中 与-> 可省直接写 it+xxx 表达式
    part2CalNum3(x){ it+3}

    part2CalNum2("nihao",block2_1)
}

fun part2CalNum1(a: Int, b: Int, block: (Int, Int) -> Int): Int = block(a, b)
fun part2CalNum2(tip: String, block: (Int, Int) -> Int): Int = block(5, 6)
fun part2CalNum3(a: Int, block: (Int) -> Int): Int = block(a)