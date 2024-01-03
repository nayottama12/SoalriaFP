package com.example.soalria

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        val txtEmail: EditText = findViewById(R.id.editTextRegisEmail)
        val txtPassword: EditText = findViewById(R.id.editTextRegisPassword)
        val txtUsername: EditText = findViewById(R.id.editTextRegisUsername)
        val txtTelephone: EditText = findViewById(R.id.editTextRegisTelp)

        val btnRegis: Button = findViewById(R.id.buttonRegistrasiAcc)

        btnRegis.setOnClickListener {
            val databaseHelper = DatabaseHelper(this)

            val email:String = txtEmail.text.toString().trim()
            val password:String = txtPassword.text.toString().trim()
            val username:String = txtUsername.text.toString().trim()
            val telephone:String = txtTelephone.text.toString().trim()

            val data:String = databaseHelper.checkData(email)

            if (data == "") {
                databaseHelper.addAccount(
                    email, password, username, telephone
                )

                val intentLogin = Intent(
                    this@RegistrasiActivity,
                    LoginActivity::class.java
                )
                startActivity(intentLogin)
            } else {
                Toast.makeText(
                    this@RegistrasiActivity, "Register failed." +
                            "Your email already registered", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}