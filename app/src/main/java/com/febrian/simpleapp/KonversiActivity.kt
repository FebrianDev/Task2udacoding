package com.febrian.simpleapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.febrian.simpleapp.databinding.ActivityKonversiBinding
import kotlin.math.abs

class KonversiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKonversiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonversiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val listSatuan: Array<String> = resources.getStringArray(R.array.list_satuan)

        binding.back.setOnClickListener{
            val intent = Intent(this@KonversiActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnKonversi.setOnClickListener {

            if(!binding.inputKonversi.text.isEmpty()) {

                var tempInput: Int = 0
                var tempResult: Int = 0
                for (i in listSatuan.indices) {
                    if (binding.listInputSatuan.selectedItem.equals(listSatuan[i])) {
                        tempInput = i
                    }

                    if (binding.listHasilKonversi.selectedItem.equals(listSatuan[i])) {
                        tempResult = i
                    }
                }

                val resultList = tempResult - tempInput
                val size = abs(resultList.toInt())

                var result = 0.0

                for (i in 1..size) {
                    result = Math.pow(10.0, i.toDouble())
                }

                val inputResult = when {
                    resultList > 0 -> {
                        (binding.inputKonversi.text.toString()).toDouble() * result
                    }
                    resultList < 0 -> {
                        (binding.inputKonversi.text.toString()).toDouble() / result
                    }
                    else -> {
                        (binding.inputKonversi.text.toString()).toDouble()
                    }
                }

                val finalResult: String = inputResult.toString()
                binding.hasilKonversi.setText(finalResult)
            }else{
                binding.inputKonversi.error = getString(R.string.field_empty)
            }
        }
    }
}