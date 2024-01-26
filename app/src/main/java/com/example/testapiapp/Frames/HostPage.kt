package com.example.testapiapp.Frames

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapiapp.Activities.MainActivity
import com.example.testapiapp.R
import com.example.testapiapp.ViewModel.HostPageViewModel
import com.example.testapiapp.ViewModel.ViewModeFactoryes.HostPageFactory


class HostPage : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_host_page, container, false)

        val backButton : Button = view.findViewById(R.id.button_to_listHost)
        val hostPageId : TextView = view.findViewById(R.id.host_page_id)
        val hostPageName : TextView = view.findViewById(R.id.host_page_name)
        val hostPageStatus : TextView = view.findViewById(R.id.host_page_status)

        backButton.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.hostPage_to_list)
        }

        var id: Int? = arguments?.getInt("id")
        var name: String? = arguments?.getString("name")
        var status: Boolean? = arguments?.getBoolean("status")

        val hViewModel : HostPageViewModel =
            ViewModelProvider(this, HostPageFactory(requireContext().applicationContext as Application, name))[HostPageViewModel::class.java]

        hViewModel.aboutHost.observe(viewLifecycleOwner, Observer {
            hostPageId.text = "ID: ${it.id.toString()}"
            hostPageName.text = "Name: ${it.name}"
            hostPageStatus.text = "Status: ${if (it.status)  "live ♥" else "death 💀"} "
        })


        return view
    }

    override fun onStart() {
        super.onStart()
    }

}