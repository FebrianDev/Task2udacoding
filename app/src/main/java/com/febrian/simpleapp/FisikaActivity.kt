package com.febrian.simpleapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.febrian.simpleapp.databinding.ActivityFisikaBinding
import com.google.android.material.tabs.TabLayout

class FisikaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFisikaBinding

    @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFisikaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.toolbar.title = getString(R.string.rumus_fisika)
        binding.toolbar.setTitleTextColor(Color.WHITE)
        binding.toolbar.navigationIcon = getDrawable(R.drawable.ic_back)
        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val sectionsPagerAdapter = SectionPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f
    }
}