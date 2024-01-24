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
import com.example.testapiapp.Model.Host
import com.example.testapiapp.R
import com.example.testapiapp.ViewModel.ListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [list.newInstance] factory method to
 * create an instance of this fragment.
 */
class list : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myview = inflater.inflate(R.layout.fragment_list, container, false)

        val listHosts : RecyclerView = myview.findViewById(R.id.ListHosts)
        val hViewModel : ListViewModel =  ViewModelProvider(this).get(ListViewModel::class.java)

        listHosts.layoutManager = LinearLayoutManager(myview.context)
        listHosts.adapter = HostsAdapter(hViewModel.listOfHost.value, myview.context)

        hViewModel.listOfHost.observe(viewLifecycleOwner, Observer {
            listHosts.adapter!!.notifyDataSetChanged()
        })

        return myview
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment list.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            list().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}