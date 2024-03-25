package com.example.core3
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private var dataList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val groupColorMap = mapOf( // Map group to color
        "UN Students" to R.color.blue_sky,
        "Xsports" to R.color.green_teal,
        "Apolitical" to R.color.red_crimson,
        "Football" to R.color.yellow_goldenrod
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false) // Inflate the item view
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataList[position] // Get the item at the specified position
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun updateData(newDataList: List<Item>) {
        dataList = newDataList // Update the dataList
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val groupView: TextView = itemView.findViewById(R.id.group)
        private val locationView: TextView = itemView.findViewById(R.id.location)
        private val datetimeView: TextView = itemView.findViewById(R.id.Datetime)

        fun bind(item: Item) {
            groupView.text = item.group
            locationView.text = item.location
            datetimeView.text = item.datetime

            // Set background color based on group
            groupColorMap[item.group]?.let { color ->
                itemView.setBackgroundColor(itemView.context.getColor(color))
            }
        }
    }
}
