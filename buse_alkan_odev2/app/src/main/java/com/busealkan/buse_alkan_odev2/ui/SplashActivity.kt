package com.busealkan.buse_alkan_odev2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.busealkan.buse_alkan_odev2.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnJoinNow.setOnClickListener {
                loginActivity()
            }
        }
    }

    private fun loginActivity() {
        val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
        startActivity(loginIntent)
        finish()
    }
}