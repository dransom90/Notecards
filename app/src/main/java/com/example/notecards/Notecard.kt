package com.example.notecards

import java.io.Serializable
import java.util.*
import java.time.*
import java.time.temporal.TemporalAdjusters

data class Notecard (var title: String, var frequency: String) : Serializable{
    override fun toString(): String = "$frequency: $title"

    var nextDueDate = LocalDate.now()

    fun calculateDueDate(){

        if(frequency == "Daily")
        {
            val dt = Date ()
            nextDueDate = nextDueDate.plusDays(1)
            return
        }

        if(frequency == "Monday" || frequency == "Tuesday" || frequency == "Wednesday" || frequency == "Thursday" ||
        frequency == "Friday" || frequency == "Saturday" || frequency == "Sunday")
        {
            getNextDayOfWeek(DayOfWeek.valueOf(frequency.toUpperCase()))
        }

        if(frequency == "January" || frequency == "February" || frequency == "March" || frequency == "April" ||
                frequency == "May" || frequency == "June" || frequency == "July" || frequency == "August" ||
                frequency == "September" || frequency == "October" || frequency == "November" || frequency == "December")
        {
            nextDueDate = nextDueDate.plusMonths(12)
        }
    }

    fun getNextDayOfWeek(weekDay: DayOfWeek)
    {
        nextDueDate = nextDueDate.with(TemporalAdjusters.next(weekDay))
    }
}