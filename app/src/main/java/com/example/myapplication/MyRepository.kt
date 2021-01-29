package com.example.myapplication

import androidx.lifecycle.LiveData

// this is not part of the android architectural component but just a layer which is used to
// provide a cleaner API


class MyRepository(private val noteDAO: NoteDAO) {

    // to get all notes
    val allNotes: LiveData<List<MyNote>> = noteDAO.getAllNotes()

    suspend fun insert(note : MyNote){
        noteDAO.insert(note)
    }
    suspend fun delete(note : MyNote){
        noteDAO.delete(note)
    }

}