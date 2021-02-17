package com.febrian.simpleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.febrian.simpleapp.databinding.ActivityLoginBinding
import com.febrian.simpleapp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val usernameValue = "udacodingid"
    private val passwordValue = "udacodingJaya2021"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            val username: String = binding.edtUsername.text.toString()
            val password: String = binding.edtPassword.text.toString()

            checkLoginEmpty(username, password)

        }
    }

    //Method for show error message
    private fun dialogError(message: String) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.error))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok), null)
            .show()
    }

    private fun loginSuccess(){
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun checkLoginValue(username: String, password: String) {
        when {
            username != usernameValue -> {
                dialogError(getString(R.string.username_wrong))
            }
            binding.edtPassword.length() < 6 -> {
                dialogError(getString(R.string.password_less))
            }
            password != passwordValue -> {
                dialogError(getString(R.string.password_wrong))
            }
            else -> {
                loginSuccess()
            }
        }
    }

    private fun checkLoginEmpty(username: String, password: String) {
        when {
            username.isEmpty() -> {
                dialogError(getString(R.string.username_empty))
            }
            password.isEmpty() -> {
                dialogError(getString(R.string.password_empty))
            }
            else -> {
                checkLoginValue(username, password)
            }
        }
    }
}