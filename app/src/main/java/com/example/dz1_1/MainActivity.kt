package com.example.dz1_1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main)
{
    private var numberOfSquares:Int?=1
    private var squares=generateStart().toMutableList()
    private val squareAdapter=MainAdapter(squares)
    private var number:Int=1

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        numberOfSquares=savedInstanceState?.getInt("MainNumber",number)
        if (numberOfSquares==null) numberOfSquares=1
        number=numberOfSquares!!
        squares=ReturnSquares(numberOfSquares,squares)
        val recyclerView=findViewById<RecyclerView>(R.id.activity_main_rv)
        recyclerView.adapter=squareAdapter
        val Button=findViewById<Button>(R.id.AddButton)
        Button.setOnClickListener {onAddClick()}
    }

    private fun onAddClick()
    {
        number+=1
        numberOfSquares=number
         squares.add(number-1,"$number")
        Log.d("TEST", "$squares")
        squareAdapter.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)
        outState.putInt("MainNumber",number)
    }
}
private fun generateStart(): List<String>
{ return listOf("1")}

private fun ReturnSquares(Num:Int?,list:MutableList<String>): MutableList<String>
{
    val num:Int
    if (Num!=null)
    { num=Num
    for (i in 2..num) list.add("$i")
    }
    return list
}
