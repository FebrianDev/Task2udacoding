package com.febrian.simpleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.febrian.simpleapp.databinding.FragmentVolumeBinding

class VolumeFragment : Fragment() {

    private lateinit var binding: FragmentVolumeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVolumeBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVolume.setOnClickListener {
            val panjang : String = binding.edtPanjang.text.toString()
            val lebar  : String = binding.edtLebar.text.toString()
            val tinggi  : String = binding.edtTinggi.text.toString()

            calculate(panjang, lebar, tinggi)
        }
    }

    private fun calculate(panjang : String, lebar : String, tinggi : String){
        when {
            panjang.isEmpty() -> {
                binding.edtPanjang.error = getString(R.string.field_empty)
            }
            lebar.isEmpty() -> {
                binding.edtLebar.error =  getString(R.string.field_empty)
            }
            tinggi.isEmpty() ->{
                binding.edtTinggi.error =  getString(R.string.field_empty)
            }
            else -> {
                binding.tvHasilVolume.text = resultToDouble(panjang, lebar, tinggi)
            }
        }
    }

    private fun resultToDouble(panjang : String, lebar : String, tinggi : String) : String{
        val result = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
        return "${result.toInt()} m3"
    }
}