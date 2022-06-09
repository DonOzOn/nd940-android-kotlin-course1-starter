package com.udacity.shoestore.screen.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeListViewModel : ViewModel(){
    // The current list shoe
    private val _listShoe = MutableLiveData<MutableList<Shoe>>();
    val listShoe : LiveData<MutableList<Shoe>>
        get() = _listShoe
    private val _nameShoe = MutableLiveData<String>();
    val nameShoe : LiveData<String>
        get() = _nameShoe

    private val _companyShoe = MutableLiveData<String>();
    val companyShoe : LiveData<String>
        get() = _companyShoe

    private val _sizeShoe = MutableLiveData<String>();
    val sizeShoe : LiveData<String>
        get() = _sizeShoe

    private val _descShoe = MutableLiveData<String>();
    val descShoe : LiveData<String>
        get() = _descShoe

    private val _submit = MutableLiveData<Boolean>();
    val submit : LiveData<Boolean>
        get() = _submit
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
     fun addShoe(shoe: Shoe){
        Log.i("getNote", "getNote")
        _listShoe.value?.add(shoe)
    }

    fun onChangeName(text : String){
        _nameShoe.value = text
    }

    fun onChangeCompany(text : String){
        _companyShoe.value = text
    }

    fun onChangeSize(text : String){
        _sizeShoe.value = text
    }

    fun onChangeDesc(text : String){
        _descShoe.value = text
    }

    fun isSubmit(submit : Boolean){
        _submit.value = submit
    }

    override fun onCleared() {
        super.onCleared()

    }

}