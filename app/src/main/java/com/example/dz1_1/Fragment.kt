package com.example.dz1_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Fragment: Fragment(){
    private var numberOfSquares:Int=1
    private var squares=mutableListOf<String>()
    private val squareAdapter=MainAdapter(squares)
    private val saveKey:String="saveKey"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, null,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null)
        numberOfSquares=savedInstanceState.getInt(saveKey,numberOfSquares)
        squares=returnSquares(numberOfSquares,squares)
        val recyclerView=view.findViewById<RecyclerView>(R.id.activity_main_rv)
        recyclerView.adapter=squareAdapter
        val button=view.findViewById<Button>(R.id.AddButton)
        button.setOnClickListener {onAddClick()}
    }

    private fun onAddClick()
    {
        squares.add("$numberOfSquares")
        numberOfSquares+=1
        squareAdapter.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)
        outState.putInt(saveKey,numberOfSquares)
    }
}

private fun returnSquares(Num:Int,list:MutableList<String>): MutableList<String>
{
        for (i in 1 until Num) list.add("$i")
    return list
}