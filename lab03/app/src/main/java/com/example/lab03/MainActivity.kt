package com.example.lab03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.example.lab03.database.User
import com.example.lab03.database.UserDatabase
import com.example.lab03.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db:UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the Room database
        db = Room.databaseBuilder(applicationContext,UserDatabase::class.java,"my-db").build()


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

            if (!email.contains("@")){
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (password != password2){
                Toast.makeText(this, "Password mismatch", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //creating a user object
            val user = User(email=email, name = name, mobile = mobile, password = password)

            // Save user data to the database using a coroutine
            GlobalScope.launch {
                db.userDao().insertUser(user)
            }

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