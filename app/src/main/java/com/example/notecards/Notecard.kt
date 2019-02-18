package com.example.notecards

import java.util.*

data class Notecard (var title: String, var frequency: String, var nextDueDate: Date){
    override fun toString(): String = "$frequency: $title"
}