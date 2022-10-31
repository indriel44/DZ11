package com.example.dz1_1

import android.graphics.Color
import android.location.GnssAntennaInfo.Listener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainAdapter(
    private val squares: List<String>,
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.square, null)
         return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(squares[position])


     }
//
     override fun getItemCount(): Int {
         return squares.size
     }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val number: TextView = itemView.findViewById(R.id.TextView_square)

        fun bind(square: String) {
            var i=Integer.parseInt(square)
            number.text = square
            if (i%2==0)
            {number.setBackgroundColor(Color.RED)}
            else number.setBackgroundColor(Color.BLUE)
            Log.d("TEST", "$i")
        }
    }
}

