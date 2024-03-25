package com.example.core3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: List<Item>
    private lateinit var originalDataList: List<Item>
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) // Use the toolbar
        setSupportActionBar(toolbar) // Set the toolbar as the app bar

        recyclerView = findViewById(R.id.recyclerView) // Initialize the RecyclerView
        originalDataList = DataFile.getFileContents(this) // Get the data from the raw resource
        dataList = originalDataList // Initialize the dataList with the original data
        adapter = ItemAdapter(dataList) // Initialize the adapter with the dataList
        recyclerView.adapter = adapter // Set the adapter to the RecyclerView
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menutoolbar, menu) // Inflate the menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) { // Handle menu item selection
            R.id.student -> {
                filterData("UN Students")
                true
            }
            R.id.xsports -> {
                filterData("Xsports")
                true
            }
            R.id.apolitical -> {
                filterData("Apolitical")
                true
            }
            R.id.football -> {
                filterData("Football")
                true
            }
            R.id.all -> {
                filterData(null) // Passing null to show all
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun filterData(group: String?) {
        dataList = if (group != null) {
            originalDataList.filter { it.group == group } // Filter the list
        } else {
            originalDataList // Show full list
        }
        adapter.updateData(dataList) // Update the adapter with the new data
        adapter.notifyDataSetChanged() // Notify the adapter of the change
    }


}
