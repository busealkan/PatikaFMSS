package com.busealkan.dicegameapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.busealkan.dicegameapp.R
import com.busealkan.dicegameapp.databinding.ActivityMainBinding
import com.busealkan.dicegameapp.utils.AlertUtil
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnZarAt.setOnClickListener {
                rollDice()
            }
        }
    }


    override fun onBackPressed() {
        exitAlert()
    }


    private fun rollDice() {
        val random= Random().nextInt(6)+1
        //val random= (1..6).random()
        val drawable= when(random){
            1 ->{
                R.drawable.ic_zarbir
            }
            2 ->{
                R.drawable.ic_zariki
            }
            3 ->{
                R.drawable.ic_zaruc
            }
            4 ->{
                R.drawable.ic_zardort
            }
            5 ->{
                R.drawable.ic_zarbes
            }
            else ->{
                R.drawable.ic_zaralti
            }
        }
        binding.apply {
            imgZar.setImageResource(drawable)
        }

    }

    private fun exitAlert() {
        AlertUtil.alertDialogGoster(this@MainActivity,R.style.AlertDialogTheme,resources.getDrawable(R.drawable.exiticon), resources.getString(R.string.alertCikisTitle),resources.getString(R.string.alertCikisMessage),resources.getString(R.string.alertCikisNegativeButon),resources.getString(R.string.alertCikisPozitifButon))
    }

}