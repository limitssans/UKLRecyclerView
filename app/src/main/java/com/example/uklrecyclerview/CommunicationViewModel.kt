package com.example.uklrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunicationViewModel : ViewModel() {
    private val mName = MutableLiveData<String>()
    val name: LiveData<String>
        get() = mName

    fun setName(name: String) {
        mName.value = name

    }
    private val mEmail = MutableLiveData<String>()
    val email: LiveData<String>
        get() = mEmail

    fun setEmail(name: String) {
        mEmail.value = name
    }
}

