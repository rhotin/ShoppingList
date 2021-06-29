package com.rhappdeveloper.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rhappdeveloper.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    //update and insert function
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    //delete function
    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}