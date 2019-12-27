package net.adrote.toolboxtest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.adrote.toolboxtest.api.ApiClient
import net.adrote.toolboxtest.api.AuthRequest
import net.adrote.toolboxtest.api.DataResponse
import net.adrote.toolboxtest.ui.model.Data

class MainViewModel : ViewModel() {

    private val client = ApiClient.create()
    //private var dataList = MutableLiveData<DataResponse>()
    private var dataList = MutableLiveData<List<Data>>()
    //private var dataList = mutableListOf<Data>()

    fun authenthicate() {
        viewModelScope.launch (Dispatchers.IO){
            var body = AuthRequest("ToolboxMobileTest")

            val result = client.signIn(body)
            var responseBody = result.body()
            if(result.isSuccessful && responseBody != null) {
                getData(responseBody.token!!)
            }

        }
    }

    fun getData(token:String) {
        viewModelScope.launch {
            val result = client.getData(token)
            var responseBody = result.body()
            if(result.isSuccessful){
                dataList.postValue(responseBody)
            }
        }

    }

    fun dataListToObserve():LiveData<List<Data>> {
        return dataList
    }
}
