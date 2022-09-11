package com.busealkan.dicegameapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.busealkan.dicegameapp.Constants
import com.busealkan.dicegameapp.R
import com.busealkan.dicegameapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        timer()

    }

    private fun timer() {
        var timerMillisInFuture = Constants.TIMER_MILLIS_IN_FUTURE
        val timerInterval = Constants.TIMER_INTERVAL
        val countDownTimer: CountDownTimer = object : CountDownTimer(timerMillisInFuture.toLong(), timerInterval.toLong()) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                secondActivity()
            }
        }
        countDownTimer.start()
    }

    private fun secondActivity() {
        val rollntent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(rollntent)
        finish()
    }
}