package com.febrian.simpleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.febrian.simpleapp.databinding.FragmentLuasBinding

class LuasFragment : Fragment() {

    private lateinit var binding : FragmentLuasBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLuasBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLuas.setOnClickListener {
            val panjang : String = binding.edtPanjang.text.toString()
            val lebar  : String = binding.edtLebar.text.toString()

            calculate(panjang, lebar)
        }
    }

    private fun calculate(panjang : String, lebar : String){
        when {
            panjang.isEmpty() -> {
                binding.edtPanjang.error = getString(R.string.field_empty)
            }
            lebar.isEmpty() -> {
                binding.edtLebar.error =  getString(R.string.field_empty)
            }
            else -> {
                binding.tvHasilLuas.text = resultToDouble(panjang, lebar)
            }
        }
    }

    private fun resultToDouble(panjang : String, lebar : String) : String{
        val result = panjang.toDouble() * lebar.toDouble()
        return "${result.toInt()} m2"
    }
}