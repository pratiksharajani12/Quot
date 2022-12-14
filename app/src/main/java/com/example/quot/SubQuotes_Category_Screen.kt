package com.example.quot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quot.databinding.ActivitySubQuotesCategoryScreenBinding
import com.example.quotes.ModalQuotes
import com.example.quotesstatus.Db_helper

class SubQuotes_Category_Screen : AppCompatActivity() {

    var list_q = arrayListOf<ModalQuotes>()
    private var size: Int = 0
    lateinit var binding: ActivitySubQuotesCategoryScreenBinding

    var image = arrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6, R.drawable.img7,
        R.drawable.img8,
        R.drawable.img9,
        R.drawable.img10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySubQuotesCategoryScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        binding.backCat.setOnClickListener {
            finish()
        }
        val id = intent.getStringExtra("list")
        val heading = intent.getStringExtra("heading")
        Log.e("TAG", "=========================$id")


        var db = Db_helper(this)

        list_q = db.ReadQuote(id!!)
        size = list_q.size
        setUpRV(list_q)

        binding.txtView.text = heading

    }
    fun setUpRV(l1: ArrayList<ModalQuotes>) {
        var adaptor = Sub_Quotes_Adaptor(this, l1,image)
        var lm = LinearLayoutManager(this)
        binding.recyclerPost.layoutManager = lm
        binding.recyclerPost.adapter = adaptor
    }
}