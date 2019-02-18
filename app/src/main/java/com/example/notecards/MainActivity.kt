package com.example.notecards

import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_view_notecards.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val frequencyAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
            DataManager.frequencies.toList())

        frequencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        noteFrequencySpinner.adapter = frequencyAdapter

        saveBtn.setOnClickListener {
            val date = calculateDueDate()
            val notecard = Notecard(titleTxt.text.toString(), noteFrequencySpinner.selectedItem.toString(), date)
            DataManager.notes.add(notecard)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun calculateDueDate() : Date {
        return Date(1,1,1)
    }
}
