package com.example.soalria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //hide title bar
        getSupportActionBar()?.hide()

        //val dbHelper = DatabaseHelper(this)
        //dbHelper.addAccount("a@gmail.com", "aaaaa", "a", "12345")

        val txtUsername:EditText = findViewById(R.id.editTextLoginEmail)
        val txtPassword:EditText = findViewById(R.id.editTextLoginPassword)

        val btnLogin: Button = findViewById(R.id.buttonLogin)
        val btnRegis : Button = findViewById(R.id.buttonregist)

        btnLogin.setOnClickListener {
            val databaseHelper = DatabaseHelper(this)
            val email = txtUsername.text.toString().trim()
            val password = txtPassword.text.toString().trim()

            val result:Boolean = databaseHelper.checkLogin(email, password)
            if (result == true){
                Toast.makeText(this@LoginActivity,"Login Sucess ",
                    Toast.LENGTH_SHORT).show()
                val intentLogin = Intent(this@LoginActivity,
                    MainActivity::class.java)
                startActivity(intentLogin)
            }else{
                Toast.makeText(this@LoginActivity, "Login Failed, Try Again!!!",
                    Toast.LENGTH_SHORT).show()
            }
        }

        btnRegis.setOnClickListener{
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
        }


    }
}