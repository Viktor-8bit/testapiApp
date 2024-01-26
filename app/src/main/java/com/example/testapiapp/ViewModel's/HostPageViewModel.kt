package com.example.testapiapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapiapp.Model.Host

class HostPageViewModel(application: Application, val hostName : String?) : AndroidViewModel(application) {

    val aboutHost = MutableLiveData<Host>()
    init {
        getHostInfo(hostName)
    }

    fun getHostInfo(host_name: String?) {
        aboutHost.value = Host(0, hostName ?: "", true)
    }
}