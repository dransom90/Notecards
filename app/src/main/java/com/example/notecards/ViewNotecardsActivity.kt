package com.example.notecards

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_view_notecards.*
import kotlinx.android.synthetic.main.content_view_notecards.*

class ViewNotecardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_notecards)
        setSupportActionBar(toolbar)

        DataManager.read(this)



        fab.setOnClickListener { view ->
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataManager.notes)
    }

    override fun onResume() {
        super.onResume()

        var sortedList = DataManager.notes.sortedWith(compareBy {it.nextDueDate})
        listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, sortedList)
    }

}
