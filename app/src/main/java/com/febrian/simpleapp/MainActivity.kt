package com.febrian.simpleapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.febrian.simpleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnKonversiSatuan.setOnClickListener(this)
        binding.btnRumusFisika.setOnClickListener(this)
        binding.btnLogout.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_konversi_satuan -> switchActivity(KonversiActivity())
            R.id.btn_rumus_fisika -> switchActivity(FisikaActivity())
            R.id.btn_logout -> switchActivity(LoginActivity())
        }
    }

    private fun switchActivity(act : Activity){
        val intent = Intent(this@MainActivity, act::class.java)
        startActivity(intent)
        finish()
    }
}