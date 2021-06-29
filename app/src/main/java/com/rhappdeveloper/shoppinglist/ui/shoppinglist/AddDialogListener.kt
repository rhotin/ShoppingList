package com.rhappdeveloper.shoppinglist.ui.shoppinglist

import com.rhappdeveloper.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}