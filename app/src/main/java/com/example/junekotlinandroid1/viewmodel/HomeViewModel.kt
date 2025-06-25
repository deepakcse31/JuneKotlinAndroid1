package com.example.junekotlinandroid1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val _search= MutableLiveData<String>()
    val search: LiveData<String>
        get() = _search

    fun setSearch(query: String) {
        _search.value = query
    }

}