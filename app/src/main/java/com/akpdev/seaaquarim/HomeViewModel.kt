package com.akpdev.seaaquarim

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akpdev.seaaquarim.data.MyDummyData

class HomeViewModel:ViewModel() {
    private val _myData = MutableLiveData<List<MyDummyData>>()
    val myData : LiveData<List<MyDummyData>>
        get() = _myData
    fun getMyData(){
        _myData.value =  listOf(
            MyDummyData(1, R.drawable.pexel_one,"10:00 PM"),
            MyDummyData(2, R.drawable.pexel_two,"10:15 PM"),
            MyDummyData(3, R.drawable.pexel_three,"10:30 PM"),
        )
    }
    init {
        getMyData()
    }
}