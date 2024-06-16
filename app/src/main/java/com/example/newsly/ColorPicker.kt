package com.example.newsly

object ColorPicker {
    val colors =
        arrayOf("#3EB9DF","#3685BC","#D36280","#E44F55")
    var colorIndex = 1
    fun getColor():String{
        return colors[colorIndex++ % colors.size]
    }
}