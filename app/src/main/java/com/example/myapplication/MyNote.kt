package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//           this way we can give name to data table if we want
@Entity(tableName = "notes_table")

//           this way we can give
//      name to column in table if we want and also add different columns in the table
class MyNote(@ColumnInfo(name = "text") val text :String ) {

   @PrimaryKey(autoGenerate = true) var id =  0    // now automatically different ids
                                                   // will be generated for particular element.
}