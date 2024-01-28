package com.example.testapiapp.Frames


import android.app.Application
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapiapp.R
import com.example.testapiapp.ViewModel.GraphicViewModel
import com.example.testapiapp.ViewModel.ViewModeFactoryes.GraphicViewModelFactory

import im.dacer.androidcharts.LineView


class process_graphic : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_process_graphic, container, false)


        val gViewModel : GraphicViewModel =
            ViewModelProvider(
                this,
                GraphicViewModelFactory(requireContext().applicationContext as Application, "amogus")
            ).get(GraphicViewModel::class.java)

        val lineView = view.findViewById(com.example.testapiapp.R.id.line_view) as LineView
        lineView.setDrawDotLine(false) //optional
        lineView.setShowPopup(LineView.SHOW_POPUPS_MAXMIN_ONLY) //optional


        gViewModel.listOfGraphicNodes.observe(viewLifecycleOwner, Observer {
            lineView.setBottomTextList(it.label)
            lineView.setColorArray(intArrayOf(Color.parseColor("#007BFF"), Color.GREEN, Color.GRAY, Color.CYAN))

            val dataLists = ArrayList<ArrayList<Int>>()
            dataLists.add(it.point)
            lineView.setDataList(dataLists) //or lineView.setFloatDataList(floatDataLists)
        })

        return view
    }

}