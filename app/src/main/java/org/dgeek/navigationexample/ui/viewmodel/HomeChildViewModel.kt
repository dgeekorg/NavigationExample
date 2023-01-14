package org.dgeek.navigationexample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeChildViewModel : ViewModel() {
    private val _number = MutableLiveData(0)
    val number: LiveData<Int> = _number
    fun increment() = _number.postValue((_number.value ?: 0) + 1)
}