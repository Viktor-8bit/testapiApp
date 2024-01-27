package com.example.testapiapp.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.testapiapp.Model.Process
import com.example.testapiapp.R
import java.util.Calendar
import java.util.Date


class ProcessAdapter(var items: List<Process>?, var context: Context)
    : RecyclerView.Adapter<ProcessAdapter.MyViewHolderProcess>() {

    class MyViewHolderProcess(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.process_list_name)
        val pid: TextView = view.findViewById(R.id.process_list_pid)
        val date: TextView = view.findViewById(R.id.process_list_date)
    }

    // Создаем параметр view, какой конкретно дизайн обрабатываем
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderProcess {
        // находим нужный дизайн
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_processes, parent, false)
        // собственный класс в котором мы находим нужные объекты
        return MyViewHolderProcess(view)
    }


    // должен возвращать потсчет количества элементов
    override fun getItemCount(): Int {
        return items!!.count()
    }

     // укажем какие данные подставим в поля которые шашли
     // перебераем все элементы массива по позиции
     @RequiresApi(Build.VERSION_CODES.O)
     @SuppressLint("SetTextI18n")
     override fun onBindViewHolder(holder: MyViewHolderProcess, position: Int) {
         holder.name.text = "Name: ${items!![position].name.toString()}"
         holder.pid.text = "Pid: ${items!![position].processId.toString()}"
         holder.date.text = "Date: ${items!![position].date.hour.toString()}:${items!![position].date.minute.toString()}:${items!![position].date.second.toString()}"
     }

}
