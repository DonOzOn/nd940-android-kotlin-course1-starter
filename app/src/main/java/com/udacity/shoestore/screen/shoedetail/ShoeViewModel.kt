package com.udacity.shoestore.screen.shoedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.models.Shoe


class ShoeViewModel : ViewModel(){
    // The current list shoe
    private val _newShoe = MutableLiveData<Shoe>();
    val newShoe : LiveData<Shoe>
        get() = _newShoe
    init {

    }

    fun setShoe(shoe : Shoe){
        _newShoe.value = shoe
    }

    override fun onCleared() {
        super.onCleared()

    }

}