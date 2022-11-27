package com.example.dz1_1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Fragment : Fragment() {
    private var numberOfSquares: Int = 1
    private var squares = mutableListOf<String>()
    private val squareAdapter = MainAdapter(squares) {number->
        activity?.supportFragmentManager?.let{
            val fragment = Fragment1().apply {
                val extras = Bundle().apply {
                    putInt( "key", number)
                }
               arguments=extras
            }


            val transaction = it.beginTransaction()
            transaction.replace(R.id.fragment, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
    private val saveKey: String = "saveKey"
    private val toast_number=6
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, null, false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            numberOfSquares = savedInstanceState.getInt(saveKey, numberOfSquares)
        }

        squares = returnSquares(numberOfSquares, squares)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView? = view.findViewById<RecyclerView>(R.id.activity_main_rv)
        if (recyclerView != null) {
            recyclerView.adapter = squareAdapter
        }
        val button = view.findViewById<Button>(R.id.AddButton)
        button.setOnClickListener { onAddClick() }

    }


    private fun onAddClick() {
        val toast = Toast.makeText(activity, resources.getString(R.string.toast_text), Toast.LENGTH_SHORT)
        if (numberOfSquares<toast_number){
        squares.add("$numberOfSquares")
        numberOfSquares += 1
        squareAdapter.notifyDataSetChanged()
        } else toast.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(saveKey, numberOfSquares)
    }
}

private fun returnSquares(Num: Int, list: MutableList<String>): MutableList<String> {
    for (i in 1 until Num) list.add("$i")
    return list
}