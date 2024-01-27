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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.testapiapp.Activities.MainActivity
import com.example.testapiapp.R
import com.example.testapiapp.ViewModel.HostPageViewModel
import com.example.testapiapp.ViewModel.ViewModeFactoryes.HostPageFactory


class HostPage : Fragment() {

    lateinit var navController: NavController

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_host_page, container, false)

        navController = (childFragmentManager.findFragmentById(R.id.nav_host_process) as NavHostFragment).navController

        val backButton : Button = view.findViewById(R.id.button_to_listHost)
        val hostPageId : TextView = view.findViewById(R.id.host_page_id)
        val hostPageName : TextView = view.findViewById(R.id.host_page_name)
        val hostPageStatus : TextView = view.findViewById(R.id.host_page_status)

        // кнопка графика
        val graphButton : Button =  view.findViewById(R.id.host_button_graph)
        graphButton.setOnClickListener{
            if (navController.currentDestination?.id != R.id.process_table) {
                navController.navigate(R.id.graphic_to_process_table)
            }
        }

        // кнопка таблицы процессов
        val processButton : Button = view.findViewById(R.id.host_button_utilization)
        processButton.setOnClickListener{
            if (navController.currentDestination?.id != R.id.process_graphic) {
                navController.navigate(R.id.table_to_process_graphic)
            }
        }

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