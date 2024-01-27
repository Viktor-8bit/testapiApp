package com.example.testapiapp.Frames

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapiapp.Activities.MainActivity
import com.example.testapiapp.Adapters.HostsAdapter
import com.example.testapiapp.Adapters.ProcessAdapter
import com.example.testapiapp.R
import com.example.testapiapp.ViewModel.HostPageViewModel
import com.example.testapiapp.ViewModel.ListViewModel
import com.example.testapiapp.ViewModel.ProcessTableViewModel
import com.example.testapiapp.ViewModel.ViewModeFactoryes.HostPageFactory
import com.example.testapiapp.ViewModel.ViewModeFactoryes.ProcessTableViewModelFactory

class process_table : Fragment() {

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_process_table, container, false)


        val hViewModel : ProcessTableViewModel =
            ViewModelProvider(
                this,
                ProcessTableViewModelFactory(requireContext().applicationContext as Application, "name")
            )[ProcessTableViewModel::class.java]


        val listProcess : RecyclerView = view.findViewById(R.id.list_process)


        listProcess.layoutManager = LinearLayoutManager(view.context)
        listProcess.adapter = ProcessAdapter(hViewModel.listOfProcess.value, view.context)

        hViewModel.listOfProcess.observe(viewLifecycleOwner, Observer {
            listProcess.adapter!!.notifyDataSetChanged()
        })


        return view
    }

}