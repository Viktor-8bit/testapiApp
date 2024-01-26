package com.example.testapiapp.ViewModel.ViewModeFactoryes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapiapp.Model.Host
import com.example.testapiapp.ViewModel.HostPageViewModel

class HostPageFactory(val application: Application, val host: Host)
    : ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HostPageViewModel(application, host) as T
    }

}