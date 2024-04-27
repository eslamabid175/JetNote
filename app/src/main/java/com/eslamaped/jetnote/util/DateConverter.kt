package com.eslamaped.jetnote.util

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.util.*

class DateConverter {

@TypeConverter
fun timestampFromDate(date:Date):Long{
    return date.time
}


    @TypeConverter
    fun datefrometimestamp(timestamp: Long):Date?{
        return Date(timestamp)
    }

}