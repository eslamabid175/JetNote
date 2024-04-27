package com.eslamaped.jetnote.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.eslamaped.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataBaseDao {

    @Query("SELECT * from notes_tbl")
    fun getNotes():Flow<List<Note>>


    @Query("SELECT * from notes_tbl where id=:id")
   suspend fun getNoteById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)


    @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun updateNote(note: Note)
    @Query("DELETE from notes_tbl")
 suspend  fun deleteAllNotes()


    @Delete
   suspend fun deleteNote(note: Note)
}

