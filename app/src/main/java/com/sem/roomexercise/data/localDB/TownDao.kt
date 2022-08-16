package com.sem.roomexercise.data.localDB

import androidx.room.Dao
import androidx.room.Query
import com.sem.roomexercise.data.models.TownModel

@Dao
interface TownDao {

    @Query("SELECT * FROM town")
    fun getAll(): List<TownModel>
}