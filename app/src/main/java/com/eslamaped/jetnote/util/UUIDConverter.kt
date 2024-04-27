package com.eslamaped.jetnote.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {
    @TypeConverter
    fun fromUUid(uuid: UUID):String?{
        return uuid.toString()
    }


    @TypeConverter
    fun UUidfromString(string: String):UUID?{
        return UUID.fromString(string)
    }

}