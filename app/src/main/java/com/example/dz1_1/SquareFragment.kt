package com.example.dz1_1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment1, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number= view.findViewById<TextView>(R.id.TextView_square1)
        val square=arguments?.getInt("key")?: 0
        number.text=square.toString()

        if (square % 2 == 0) {
            number.setBackgroundColor(Color.RED)
        } else number.setBackgroundColor(Color.BLUE)
    }

}