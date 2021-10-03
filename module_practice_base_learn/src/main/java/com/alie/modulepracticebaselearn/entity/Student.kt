package com.alie.modulepracticebaselearn.entity


data class Student(
    var name: String = "", var age: Int = 0, var content: String = "",
    var lessons: List<Lesson> = listOf()
)

data class Lesson(var name: String = "", var hour: Int = 0)
data class Member(var name: String = "")