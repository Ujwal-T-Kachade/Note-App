package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.delete

class MainActivity : AppCompatActivity(), click {

    lateinit var instanceOfViewmodel : ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val Adapter = NoteAdapter(this,this)

        myRecyclerView.adapter = Adapter

        // here first we want the instance / object of the viewModel so create above

        instanceOfViewmodel =ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ViewModel::class.java)

        instanceOfViewmodel.allData.observe(this, Observer {// exalamation marks means nullable
            ///but we dont want to upadate adapter when list is null
            // so add check
            list ->
            list?.let {
                Adapter.updateList(it)
            }
        })
    }

    override fun onItemClick(note: MyNote) {
        instanceOfViewmodel.deleteNote(note)
        Toast.makeText(this, "${note.text} DELETED", Toast.LENGTH_SHORT).show()
    }

    fun insert(view: View) {
        val note_text = inputNote.text.toString()
        inputNote.text.clear()
        if(note_text.isNotEmpty()){
            instanceOfViewmodel.InsertNote(MyNote(note_text))
        //                             creating the MyNote Object
            Toast.makeText(this, "${note_text} INSERTED", Toast.LENGTH_SHORT).show()

        }

    }
}