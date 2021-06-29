package com.rhappdeveloper.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rhappdeveloper.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase:RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instence: ShoppingDatabase? = null
        private var LOCK = Any()

        //when writing something like this: ShoppingDatabase() this function will be executed
        operator fun invoke(context: Context) = instence ?: synchronized(LOCK){
            instence ?: createDatabase(context).also { instence = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}