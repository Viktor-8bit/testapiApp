package com.example.testapiapp.ViewModel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.testapiapp.Model.Process
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class ProcessTableViewModel(application: Application, val hostName : String?) : AndroidViewModel(application) {

    val listOfProcess = MutableLiveData<MutableList<Process>>()
    init {
        listOfProcess.value = ArrayList()
        getProcessByName(hostName)
    }

    fun getProcessByName(name: String?) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")

        listOfProcess.value?.add(
            Process("Idle", 0, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("System", 4, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("Secure System", 104, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("Registry", 180, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("smss", 580, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("iisexpresstray", 18540, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("SearchProtocolHost", 13920, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("SearchFilterHost", 25644, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("dotnet", 16220, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("conhost", 21344, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("winpty-agent", 26480, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("conhost", 16908, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("JetBrains.DPA.Runner", 20640, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
        listOfProcess.value?.add(
            Process("SpyAppVer0.0.1", 4356, LocalDateTime.parse("2024-01-02T00:08:43.547258", formatter)))
    }
}