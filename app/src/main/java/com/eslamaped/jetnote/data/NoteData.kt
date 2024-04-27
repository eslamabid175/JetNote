package com.eslamaped.jetnote.data

import com.eslamaped.jetnote.model.Note

class NotesDataSource{

    fun loadNotes() :List<Note>{
        return listOf(
            Note(title = "A good Day", description = "we went to avacation"),
            Note(title = "A Movie Day", description = "we went to an"),
        )
    }
}