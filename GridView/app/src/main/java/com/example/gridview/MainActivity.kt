package com.example.gridview

import android.content.Context
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var stickersGridView: GridView
    private lateinit var adapter: StickerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        stickersGridView = findViewById(R.id.stickersGridView)
        adapter = StickerAdapter(this, listOf(
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6
        ))
        stickersGridView.adapter = adapter
    }
}

class StickerAdapter(private val context: Context, private val stickers: List<Int>) : BaseAdapter() {
    override fun getCount() = stickers.size
    override fun getItem(position: Int) = stickers[position]
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) = 
        (convertView ?: LayoutInflater.from(context).inflate(R.layout.item_sticker, parent, false)).apply {
            findViewById<ImageView>(R.id.stickerImage).setImageResource(stickers[position])
        }
}