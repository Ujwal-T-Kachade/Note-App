package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//                  view model                     extends
class ViewModel(application: Application) : AndroidViewModel(application) {

    val allData : LiveData<List<MyNote>>
    private val repository : MyRepository
    //view model ko data milega repository se
    //repository me data aaara hai notesDao se so hame pehele notedao hona
    //aur note dao milega database se by function getNoteeDao

    init {
        val dao = MyDatabase.getDatabase(application).getNoteDao()
        repository = MyRepository(dao)

        allData =  repository.allNotes

        // finaly this data we have to send into the main activity to show the user
    }
    fun deleteNote(note : MyNote) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun InsertNote(note : MyNote) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}