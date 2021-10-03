package com.alie.modulepracticebaselearn.primary

import com.alie.modulepracticebaselearn.entity.Lesson
import com.alie.modulepracticebaselearn.entity.Member
import com.alie.modulepracticebaselearn.entity.Student

/**
 * sample test for map
 * @param array Array<String>
 */
fun main(array: Array<String>) {
    doTest01()
    doTest02()
    doTest03()
}

/**
 * test map
 * translate a collection into another
 */
fun doTest01() {
    println("===doTest01")
    val listStu = listOf(Student("Tom", 15), Student("Jerry", 14), Student("Garma,13"))
    val listMember = listStu.map {
        Member(it.name)
    }
    listMember.forEach {
        println("===memberName = ${it.name}")
    }
}

/**
 * test flatmap
 *
 */
fun doTest02() {
    println("===doTest02")
    val listStu = listOf(
        Student(
            "Tom", 15,
            lessons = listOf(
                Lesson("Math"),
                Lesson("English"), Lesson
                    ("PE")
            )
        ),
        Student("Jerry", 14,
            lessons = listOf(
                Lesson("Chemistry"),
                Lesson("Physics"), Lesson
                    ("biology")
            )),
        Student("Garma",13,
            lessons = listOf(
                Lesson("History"),
                Lesson("geography"), Lesson
                    ("Politics")
            ))
    )
    val allLessons = listStu.flatMap { it.lessons.asIterable() }
    allLessons.forEach {
        println("===memberName = ${it.name}")
    }
}

fun doTest03() {
    println("===doTest01")
}