package com.eslamaped.jetnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eslamaped.jetnote.model.Note
import com.eslamaped.jetnote.util.DateConverter
import com.eslamaped.jetnote.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDataBase:RoomDatabase() {
    abstract fun   noteDao():NoteDataBaseDao
}