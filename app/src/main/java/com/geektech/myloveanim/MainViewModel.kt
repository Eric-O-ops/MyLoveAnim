package com.geektech.myloveanim

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.myloveanim.model.AnimModel

class MainViewModel: ViewModel() {

    val data: MutableLiveData<List<AnimModel>> = MutableLiveData()

    fun setList(list: List<AnimModel>){
        data.value = list

    }
}