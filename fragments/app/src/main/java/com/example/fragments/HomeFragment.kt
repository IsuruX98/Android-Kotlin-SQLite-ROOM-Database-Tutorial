package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnDisplay = view.findViewById<Button>(R.id.displayBtn)
        val editName = view.findViewById<EditText>(R.id.displayText)

        btnDisplay.setOnClickListener {
            Toast.makeText(context, "Hello,${editName.text.toString()}", Toast.LENGTH_LONG).show()
        }

        return view
    }

}