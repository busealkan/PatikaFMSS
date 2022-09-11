package com.busealkan.buse_alkan_odev2.ui

import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.busealkan.buse_alkan_odev2.R
import com.busealkan.buse_alkan_odev2.databinding.ActivityLoginBinding
import com.busealkan.buse_alkan_odev2.util.AlertUtil
import com.busealkan.buse_alkan_odev2.util.Constants


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnLogin.setOnClickListener {
                nullCheck()
            }

            ellipseBackLogin.setOnClickListener {
                exitAlertShow()
            }

            txtCreateAccount.setOnClickListener {
                signUpActivity()
            }

            txtUsername.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    val username=txtUsername.text.toString()

                    if(username.length == 0)
                    {
                        lineUsername.setBackgroundResource(R.drawable.ic_line_red)
                    }
                    else{
                        lineUsername.setBackgroundResource(R.drawable.ic_line_black)
                    }
                }

                override fun beforeTextChanged(s: CharSequence,start: Int,count: Int,after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            })

            txtPassword.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    val password=txtPassword.text.toString()

                    if(password.length == 0)
                    {
                        linePassword.setBackgroundResource(R.drawable.ic_line_red)
                    }
                    else{
                        linePassword.setBackgroundResource(R.drawable.ic_line_black)
                    }
                }

                override fun beforeTextChanged(s: CharSequence,start: Int,count: Int,after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            })

        }
    }

    private fun nullCheck() {
        var username: kotlin.String? = binding.txtUsername.text.toString().trim()
        var password: kotlin.String? = binding.txtPassword.text.toString().trim()
        if (username.equals(resources.getString(R.string.nullCheck)) || password.equals(resources.getString(R.string.nullCheck)) ) {
            Toast.makeText(applicationContext, resources.getString(R.string.toastNullField), Toast.LENGTH_SHORT).show()

            binding.lineUsername.setBackgroundResource(R.drawable.ic_line_red)
            binding.linePassword.setBackgroundResource(R.drawable.ic_line_red)
        } else {
            binding.lineUsername.setBackgroundResource(R.drawable.ic_line_black)
            binding.linePassword.setBackgroundResource(R.drawable.ic_line_black)

            userControl(username, password)
        }
    }

    private fun userControl(username: String?, password: String?) {
        if(username.toString().equals(Constants.USERNAME) && password.toString().equals(Constants.PASSWORD)){
            Toast.makeText(this@LoginActivity, resources.getString(R.string.toastLoginSuccessful)+" "+username!!, Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@LoginActivity, resources.getString(R.string.toastLoginFailed), Toast.LENGTH_SHORT).show()
        }
    }

     private fun signUpActivity() {
        val signUpIntent = Intent(this@LoginActivity, SignUpActivity::class.java)
        startActivity(signUpIntent)
        finish()
    }

    private fun exitAlertShow() {
        AlertUtil.alertDialogShow(this@LoginActivity,
            R.style.AlertDialogTheme,resources.getDrawable(R.drawable.exiticon), resources.getString(R.string.toastLogOut),resources.getString(R.string.toastExitApplication),resources.getString(R.string.toastExit),resources.getString(R.string.toastCancel)
        )
    }
}
