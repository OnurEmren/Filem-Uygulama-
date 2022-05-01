package com.onuremren.tarif.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.tarif.R
import com.onuremren.tarif.model.Search
import kotlinx.android.synthetic.main.row_items.view.*

class SearchAdapter(private val dataSet: ArrayList<*>, mContext: Context) :
    ArrayAdapter<Any?>(mContext, R.layout.row_items, dataSet) {
    private class ViewHolder {
        lateinit var txtName: TextView
        lateinit var checkBox: CheckBox
    }
    override fun getCount(): Int {
        return dataSet.size
    }
    override fun getItem(position: Int): Search {
        return dataSet[position] as Search
    }
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        val result: View
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView =
                LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false)
            viewHolder.txtName =
                convertView.findViewById(R.id.txtName)
            viewHolder.checkBox =
                convertView.findViewById(R.id.checkBox)
            result = convertView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }
        val item: Search = getItem(position)
        viewHolder.txtName.text = item.name
        viewHolder.checkBox.isChecked = item.checked
        return result
    }
}



