package com.example.testapiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class HostPage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_host_page, container, false)

        val back_button : Button = view.findViewById(R.id.button_to_listHost)

        back_button.setOnClickListener({
            (activity as MainActivity).navController.navigate(R.id.hostPage_to_list)
        })

        return view
    }

}