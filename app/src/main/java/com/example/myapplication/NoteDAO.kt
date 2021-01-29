package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : MyNote)

    @Delete()
    suspend fun delete(note : MyNote)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<MyNote>>
}