package com.eslamaped.jetnote.rebository

import com.eslamaped.jetnote.data.NoteDataBaseDao
import com.eslamaped.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRebository@Inject constructor(private val noteDataBaseDao: NoteDataBaseDao){
suspend fun addNote(note:Note)=noteDataBaseDao.insertNote(note)
suspend fun updateNote(note:Note)=noteDataBaseDao.updateNote(note)
suspend fun deleteNote(note:Note)=noteDataBaseDao.deleteNote(note)
suspend fun deleteAllNotes()=noteDataBaseDao.deleteAllNotes()

  //مااستخدمناش suspend عشان Flow بتشتغل ف ثرييد تانية عادي
    fun getAllNotes(): Flow<List<Note>>
    = noteDataBaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}