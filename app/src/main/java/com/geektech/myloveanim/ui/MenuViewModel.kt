package com.geektech.myloveanim.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.myloveanim.model.AnimModel

class MenuViewModel : ViewModel() {

    val data: MutableLiveData<List<AnimModel>> = MutableLiveData()

    init {
        Log.e("AAA", "VM was created" )
    }

    fun setList(list: List<AnimModel>) {
        data.value =  list
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "VM was cleared" )
    }
}