package com.example.testapiapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapiapp.Model.Host
import com.example.testapiapp.R

class HostsAdapter(var items: List<Host>, var context: Context)
    : RecyclerView.Adapter<HostsAdapter.MyViewHolder>(){

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val id: TextView = view.findViewById(R.id.host_id)
        val name: TextView = view.findViewById(R.id.host_name)
        val status: TextView = view.findViewById(R.id.host_status)
    }

    // Создаем параметр view, какой конкретно дизайн обрабатываем
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // находим нужный дизайн
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_hosts, parent, false)
        // собственный класс в котором мы находим нужные объекты
        return MyViewHolder(view)
    }

    // должен возвращать потсчет количества элементов
    override fun getItemCount(): Int {
        return items.count()
    }

    // укажем какие данные подставим в поля которые шашли
    // перебераем все элементы массива по позиции
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = items[position].id.toString()
        holder.name.text = items[position].name
        holder.status.text = items[position].status.toString()
    }
}