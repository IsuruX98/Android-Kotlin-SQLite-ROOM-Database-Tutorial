package com.example.lab03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lab03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cancelBtn.setOnClickListener {
            binding.email.setText("")
            binding.username.setText("")
            binding.mobile.setText("")
            binding.password.setText("")
            binding.password2.setText("")

        }

        binding.submitBtn.setOnClickListener {

            val email = binding.email.text.toString()
            val name = binding.username.text.toString()
            val mobile = binding.mobile.text.toString()
            val password = binding.password.text.toString()
            val password2 = binding.password2.text.toString()

            showAlertBox(this, name, email, mobile, password, password2)
        }

    }

    private fun showAlertBox(
        context: Context,
        name: String,
        email: String,
        mobile: String,
        password: String,
        password2: String,
    ) {
        val builder = AlertDialog.Builder(context)
        val message =
            "Email: $email\n" + "Phone: $mobile\n" + "Passwords: ${if (password == password2) "Matching" else "NotMatching"}."
        builder.setTitle("Welcome $name !")
        builder.setMessage(message)

        builder.setPositiveButton("OK") { _, _ ->
            Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Cancel") { _, _ ->

        }

        val dialog = builder.create()
        dialog.show()
    }

}