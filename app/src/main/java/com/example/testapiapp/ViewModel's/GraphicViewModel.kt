package com.example.testapiapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapiapp.Model.GraphicNode
import com.example.testapiapp.Model.Host
import java.util.Date

class GraphicViewModel(application: Application, val hostName : String) : AndroidViewModel(application) {

    val listOfGraphicNodes = MutableLiveData<GraphicNode>()

    init {
        getGraphic(hostName, Date())
    }

    fun getGraphic(host_name : String, date : Date) {
        val labels = ArrayList<String>()
        labels.add("amogus1")
        labels.add("amogus2")
        labels.add("amogus3")
        labels.add("amogus4")
        labels.add("amogus5")

        val values = ArrayList<Int>()
        values.add(10)
        values.add(20)
        values.add(5)
        values.add(50)
        values.add(55)

        listOfGraphicNodes.value = GraphicNode(labels, values)
    }
}