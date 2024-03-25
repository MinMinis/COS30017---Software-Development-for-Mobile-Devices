package com.example.core3

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object DataFile {
    fun getFileContents(context: Context): List<Item> {
        val dataList = mutableListOf<Item>()
        // Read from raw resource
        val inputStream = context.resources.openRawResource(R.raw.groups) // Open the raw resource
        val reader = BufferedReader(InputStreamReader(inputStream)) // Create a BufferedReader
        var isFirstLine = true // Flag to skip the first line
        // Read data from raw resource
        reader.forEachLine { line ->
            if (!isFirstLine) { // Skip the first line
                val pieces = line.split(",") // Split the line by comma
                if (pieces.size == 5) {
                    val dataItem =
                        Item(pieces[0], pieces[1], pieces[2], pieces[3], pieces[4]) // Create an Item object
                    dataList.add(dataItem) // Add the Item object to the dataList
                }
            } else {
                isFirstLine = false // Set isFirstLine to false after skipping the first line
            }
        }
        reader.close() // Close the BufferedReader
        inputStream.close() // Close the InputStream
        return dataList
    }
}
