package com.alie.modulepracticeflow

import java.util.Scanner

fun main(array: Array<String>) {

    val scanner  = Scanner(System.`in`)
    doCheckReturn(scanner.nextLine())
}

//0-670-82162-4
fun doCheckReturn(input:String):String {

    val temp = input
    val inputLastIdCodeChar =temp.last()

    val numString = input.replace("-","");
    val numChar = numString.toCharArray()
    var allCode = 0
    numChar.forEachIndexed { index: Int, c: Char ->

       val current = c.toInt() * (index + 1)
        allCode += current
    }

    val result:Int = allCode % 11
    val calLastCodeChar = when(result == 10) {
        true-> 'X'
        else-> result.toChar()
    }

  return  when(inputLastIdCodeChar.toString() == calLastCodeChar.toString()) {
        true->"Right"
        else-> input.drop(11).plus(calLastCodeChar.toString())
    }

}
