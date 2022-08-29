package com.example.quotesstatus

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quot.MainActivity
import com.example.quot.R
import com.example.quot.SubQuotes_Category_Screen
import com.example.quotes.ModalData

class Category_Adaptor(
    val homePage: MainActivity,
    val l1: ArrayList<ModalData>,
    val image: Array<Int>,
) : RecyclerView.Adapter<Category_Adaptor.ViewData>() {

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_main = itemView.findViewById<TextView>(R.id.category_main)
        var quotes = itemView.findViewById<RelativeLayout>(R.id.quotes)
        var img_change = itemView.findViewById<ImageView>(R.id.img_change)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view =
            LayoutInflater.from(homePage).inflate(R.layout.category_design, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.category_main.text = l1[position].name

        holder.quotes.setOnClickListener {



            var number = l1[position]._id
            var heading = l1[position].name

            var intent = Intent(homePage, SubQuotes_Category_Screen::class.java)
            intent.putExtra("list", number)
            intent.putExtra("heading", heading)
            homePage.startActivity(intent)

//            var db = Db_helper(homePage)
//
//            db.ReadQuote()
////            Toast.makeText(this, "" + ps, Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int {
        return l1.size
    }
}