package com.busealkan.buse_alkan_odev3_lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busealkan.buse_alkan_odev3_lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    fun init(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}