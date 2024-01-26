package com.example.testapiapp.Frames

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapiapp.Adapters.HostsAdapter
import com.example.testapiapp.MainActivity
import com.example.testapiapp.Model.Host
import com.example.testapiapp.R
import com.example.testapiapp.ViewModel.ListViewModel


class list : Fragment() {


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myview = inflater.inflate(R.layout.fragment_list, container, false)

        val listHosts : RecyclerView = myview.findViewById(R.id.ListHosts)
        val hViewModel : ListViewModel =  ViewModelProvider(this).get(ListViewModel::class.java)

        listHosts.layoutManager = LinearLayoutManager(myview.context)
        listHosts.adapter = HostsAdapter(hViewModel.listOfHost.value, myview.context, (activity as MainActivity))

        hViewModel.listOfHost.observe(viewLifecycleOwner, Observer {
            listHosts.adapter!!.notifyDataSetChanged()
        })

        return myview
    }


}