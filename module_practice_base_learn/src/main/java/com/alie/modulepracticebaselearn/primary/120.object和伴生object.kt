package com.alie.modulepracticebaselearn.primary

/**
 * trans kt to java to find the difference
 */
fun main(array: Array<String>) {

    CarTwo120.generateIt()
}

/**
 * 【整个类静态实例化】
 * 这实际上是在静态代码块中实例化Car120
 */
object Car120 {
    val mName = "alie"
    fun generateIt() = 0
}


class CarTwo120 {
    val mAge = 12

    /**
     * 【内部类静态实例化】
     * 这实际上是在CarTwo120中创建了一个静态内部类，并实例化它
     */
    companion object {
        val mName = "loxiji"
        fun generateIt() = 0
    }
}