package com.example.notecards

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataManager {
    const val PREFS_FILENAME = "com.example.notecards.prefs"
    const val KEY = "notes"

    var notes = ArrayList<Notecard>()
    val frequencies = listOf("Daily", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
        "Sunday", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
        "November", "December")


    fun write(context: Context)
    {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(notes)
        editor.putString(KEY, json)
        editor.apply()
    }

    fun read(context: Context)
    {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json = prefs.getString(KEY, null)
        val testType = object : TypeToken<ArrayList<Notecard>>() {}.type
        val newNotecards = Gson().fromJson<ArrayList<Notecard>>(json, testType)

        if(newNotecards == null)
        {
            notes = ArrayList<Notecard>()
        }

        else
        {
            notes = newNotecards
        }
    }

    //inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)
}