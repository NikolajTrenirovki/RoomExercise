package com.sem.roomexercise.data.localDB

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sem.roomexercise.data.models.TownModel

@Database(entities = [TownModel::class], version = 1)
abstract class TempLocalDB : RoomDatabase() {

}