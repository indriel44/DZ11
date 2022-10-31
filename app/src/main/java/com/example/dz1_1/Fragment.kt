package com.example.dz1_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Fragment: Fragment(){
    private var numberOfSquares:Int?=1
    private var squares=generateStart().toMutableList()
    private val squareAdapter=MainAdapter(squares)
    private var number:Int=1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, null,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberOfSquares=savedInstanceState?.getInt("MainNumber",number)
        if (numberOfSquares==null) numberOfSquares=1
        number=numberOfSquares!!
        squares=ReturnSquares(numberOfSquares,squares)
        val recyclerView=view.findViewById<RecyclerView>(R.id.activity_main_rv)
        recyclerView.adapter=squareAdapter
        val Button=view.findViewById<Button>(R.id.AddButton)
        Button.setOnClickListener {onAddClick()}
    }

    private fun onAddClick()
    {
        number+=1
        numberOfSquares=number
        squares.add(number-1,"$number")

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