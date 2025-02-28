package com.example.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager)
        viewPager2.adapter = ViewPagerAdapter()
    }
}

class ViewPagerAdapter: RecyclerView.Adapter<ViewHolder>(){
    private val itemList = listOf(
        "You are never too old to set another goal or to dream a new dream.",
        "Success is not final, failure is not fatal: it is the courage to continue that counts.",
        "You don't always need a plan. Sometimes you just need to breathe, trust, let go and see what happens."
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentText = itemList[position]
        holder.bind(currentText)
    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val swipeableText = itemView.findViewById<TextView>(R.id.swipeableText)
    fun bind(text: String) {
        swipeableText.text = text
    }
}