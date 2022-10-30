package com.example.dz1_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var numberOfSquares:Int=1
    private var squares=generateStart().toMutableList()
    private val squareAdapter=MainAdapter(squares)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView=findViewById<RecyclerView>(R.id.activity_main_rv)
        recyclerView.adapter=squareAdapter
        val Button=findViewById<Button>(R.id.AddButton)
        Button.setOnClickListener {onAddClick()}



    }
    private fun onAddClick(){
        numberOfSquares+=1
         squares.add(numberOfSquares-1,"$numberOfSquares")
        squareAdapter.notifyDataSetChanged()

    }
}
private fun generateStart(): List<String> {
    return listOf("1")}
