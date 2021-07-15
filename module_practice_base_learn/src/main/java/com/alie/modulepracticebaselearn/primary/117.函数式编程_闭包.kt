package com.alie.modulepracticebaselearn.primary

/**
 * 闭包
 * 【函返引外量】
 *  定义(python)：一个函数返回一个内部函数，这个内部函数引用了外部函数参数或变量，我们称这个内部函数为闭包
 *  定义(kotlin):在kotlin中可中，闭包就是lamda表达式
 */
fun main(array: Array<String>) {
    val method = doWork117()

    method()
    method()
    method()
}

fun doWork117():()->Unit {
    var a = 10
    return { println(++a) }
}