package com.example.seki.androidCustomLinklifytextSample

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class RecyclerListAdapter: RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {

    private val mData: MutableList<ListData> = mutableListOf()

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: ViewDataBinding

        init {
            (v.findViewById<TextView>(R.id.clickable_text)).movementMethod = LinkMovementMethod.getInstance()
            this.binding = DataBindingUtil.bind(v)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.setVariable(BR.data, mData[position])
    }

    override fun getItemCount() = mData.size

    fun addData(data: ListData) {
        mData.add(0, data)
        notifyDataSetChanged()
    }
}
