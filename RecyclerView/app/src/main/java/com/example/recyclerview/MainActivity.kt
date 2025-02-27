package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var dataList: ArrayList<DataClass>

    private lateinit var imageList: Array<Int>

    private lateinit var titleList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageList = arrayOf(
            R.drawable.camera,
            R.drawable.clock,
            R.drawable.rating,
            R.drawable.edit,
            R.drawable.camera,
            R.drawable.clock,
            R.drawable.rating,
            R.drawable.edit,
            R.drawable.camera,
            R.drawable.clock,
            R.drawable.rating,
            R.drawable.edit
        )

        titleList = arrayOf(
            "Camera",
            "Time Picker",
            "Rating Bar",
            "Edit Text",
            "Camera",
            "Time Picker",
            "Rating Bar",
            "Edit Text",
            "Camera",
            "Time Picker",
            "Rating Bar",
            "Edit Text"
        )

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()
    }

    private fun getData() {
        for (i in imageList.indices) {
            dataList.add(DataClass(imageList[i], titleList[i]))
        }

        recyclerView.adapter = AdapterClass(dataList) {item ->
            Toast.makeText(
                this,
                "You hve clicked on ${item.dataTitle} from the list.",
                Toast.LENGTH_SHORT
            ).show()}
    }
}