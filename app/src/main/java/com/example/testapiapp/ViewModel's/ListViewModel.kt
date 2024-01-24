package com.example.testapiapp.ViewModel

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapiapp.Model.Host

class ListViewModel: ViewModel() {

    val listOfHost = MutableLiveData<MutableList<Host>>()
    init {
        listOfHost.value = ArrayList()
        listOfHost.value?.add(Host(1, "AmogusPC", false))
        listOfHost.value?.add(Host(2, "DESKTOP-050E4JN", true))
        listOfHost.value?.add(Host(3, "WIN-8PJNE1C8M8J", true))
        GetHosts();
    }

    // отправит запрос на http://localhost:5160/api/pc/GetAllPC
    fun GetHosts() {
        object :CountDownTimer(20000, 5000) {
            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                listOfHost.value?.add(Host(10, "test_host", false))
                listOfHost.value = listOfHost.value
            }
        }.start()
    }
}