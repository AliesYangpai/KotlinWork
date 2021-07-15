package com.alie.modulepracticebaselearn.primary

/**
 *  高阶函数
 * 【函参函返】
 */
fun main(array: Array<String>) {


    // 普通函数的使用
    val a = add118(5, 5)
    val b = minus118(5, 5)
    println(" a= $a b=$b")

    // 高阶函数的使用
   val num = calNum118(5,2, ::add118) // 此处传入函数的引用  ::add118
    println(num)
}

fun add118(a:Int, b:Int):Int  = a+b
fun minus118(a:Int,b:Int):Int = a - b
fun calNum118(a:Int, b:Int, block:(Int, Int)->Int):Int = block(a,b)