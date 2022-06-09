package com.udacity.shoestore.screen.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeListViewModel : ViewModel(){
    // The current list shoe
    private val _listShoe = MutableLiveData<ArrayList<Shoe>>();
    val listShoe : LiveData<ArrayList<Shoe>>
        get() = _listShoe
    init {
        val list = arrayListOf<Shoe>()
        Log.i("ShoeListViewModel","ShoeListViewModel created")
        list.add( Shoe("Nike Air", 47.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 42.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 43.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 41.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 45.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 49.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 47.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 42.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 43.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 41.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 45.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 49.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 47.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 42.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 43.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 41.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 45.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 49.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 47.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 42.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 43.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 41.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 45.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 49.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 47.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 42.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 43.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 41.0,"Nike", "Shoe for man"))
        list.add( Shoe("Nike Air", 45.0,"Nike", "Shoe for man"))
        list.add(Shoe("Nike Air", 49.0,"Nike", "Shoe for man"))
        _listShoe.value = list
        Log.i("listShoe", _listShoe.value.toString())

    }
    private fun getNote(){
        Log.i("getNote", "getNote")
    }

    override fun onCleared() {
        super.onCleared()

    }

}