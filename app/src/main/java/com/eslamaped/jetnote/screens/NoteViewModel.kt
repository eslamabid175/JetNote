package com.eslamaped.jetnote.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslamaped.jetnote.data.NotesDataSource
import com.eslamaped.jetnote.model.Note
import com.eslamaped.jetnote.rebository.NoteRebository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository :NoteRebository)  : ViewModel() {
 private   val _noteList= MutableStateFlow<List<Note>>(emptyList())
    val noteList=_noteList.asStateFlow()
init {
    viewModelScope.launch(Dispatchers.IO) {
        repository.getAllNotes().distinctUntilChanged()
            .collect{
                listofNotes ->
                if (listofNotes.isNullOrEmpty()){
                    Log.d("Empty","EmptyList")
                }else{
                    _noteList.value=listofNotes
                }
            }
    }
   // noteList.addAll(NotesDataSource().loadNotes())
}
 fun addNote(note: Note)=viewModelScope.launch {     repository.addNote(note) }
 fun updateNote(note: Note)=viewModelScope.launch {     repository.updateNote(note) }
 fun deletNote(note: Note)=viewModelScope.launch {repository.deleteNote(note) }

}