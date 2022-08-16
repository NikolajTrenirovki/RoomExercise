package com.sem.roomexercise.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "town")
class TownModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "name")
    val name:String

)