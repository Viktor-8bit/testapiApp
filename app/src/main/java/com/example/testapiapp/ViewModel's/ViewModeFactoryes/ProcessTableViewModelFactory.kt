package com.example.testapiapp.ViewModel.ViewModeFactoryes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapiapp.ViewModel.ProcessTableViewModel

class ProcessTableViewModelFactory(val application: Application, val text: String)
    : ViewModelProvider.AndroidViewModelFactory(application) {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProcessTableViewModel(application, text) as T
        }
}