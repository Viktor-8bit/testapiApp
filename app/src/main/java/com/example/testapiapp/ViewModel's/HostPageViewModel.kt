package com.example.testapiapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testapiapp.Model.Host

class HostPageViewModel(application: Application, val host : Host) : AndroidViewModel(application) {

    lateinit var AboutHost : LiveData<Host>
    init {

    }
}