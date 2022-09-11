package com.busealkan.buse_alkan_odev2.ui


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.busealkan.buse_alkan_odev2.R
import com.busealkan.buse_alkan_odev2.databinding.ActivitySignUpBinding
import com.busealkan.buse_alkan_odev2.util.Constants
import com.google.android.material.snackbar.Snackbar


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSignUp.setOnClickListener {
                nullCheck()
            }

            ellipseBackLogin.setOnClickListener {
                loginActivity()
            }

            txtEnterEmail.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    val email=txtEnterEmail.text.toString()

                    if(email.length == 0)
                    {
                        lineEmail.setBackgroundResource(R.drawable.ic_line_red)
                    }
                    else{
                        lineEmail.setBackgroundResource(R.drawable.ic_line_black)
                    }
                }

                override fun beforeTextChanged(s: CharSequence,start: Int,count: Int,after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            })

            txtCreateUsername.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    val username=txtCreateUsername.text.toString()

                    if(username.length == 0)
                    {
                        lineCreateUserName.setBackgroundResource(R.drawable.ic_line_red)
                    }
                    else{
                        lineCreateUserName.setBackgroundResource(R.drawable.ic_line_black)
                    }
                }

                override fun beforeTextChanged(s: CharSequence,start: Int,count: Int,after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            })

            txtCreatePassword.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    val password=txtCreatePassword.text.toString()

                    if(password.length == 0)
                    {
                        lineCreatePassword.setBackgroundResource(R.drawable.ic_line_red)
                    }
                    else{
                        lineCreatePassword.setBackgroundResource(R.drawable.ic_line_black)
                    }
                }

                override fun beforeTextChanged(s: CharSequence,start: Int,count: Int,after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            })
        }
    }

    private fun nullCheck() {
        var username: kotlin.String? = binding.txtCreateUsername.text.toString().trim()
        var email: kotlin.String? = binding.txtEnterEmail.text.toString().trim()
        var password: kotlin.String? = binding.txtCreatePassword.text.toString().trim()

        if (username.equals(resources.getString(R.string.nullCheck)) || email.equals(resources.getString(R.string.nullCheck))|| password.equals(resources.getString(
                R.string.nullCheck)) ) {
            Toast.makeText(applicationContext, resources.getString(R.string.toastNullField), Toast.LENGTH_LONG).show()

            binding.lineEmail.setBackgroundResource(R.drawable.ic_line_red)
            binding.lineCreateUserName.setBackgroundResource(R.drawable.ic_line_red)
            binding.lineCreatePassword.setBackgroundResource(R.drawable.ic_line_red)
        } else {
            if(emailFormatControl(email)==false){
                Toast.makeText(applicationContext, resources.getString(R.string.toastEmailFormat), Toast.LENGTH_LONG).show()
            }
            else{
                binding.lineEmail.setBackgroundResource(R.drawable.ic_line_black)
                binding.lineCreateUserName.setBackgroundResource(R.drawable.ic_line_black)
                binding.lineCreatePassword.setBackgroundResource(R.drawable.ic_line_black)

                userControl(username, email)
            }
        }
    }

    private fun emailFormatControl(email: CharSequence?): Boolean {
        if (TextUtils.isEmpty(email)) {
            return true
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

    private fun userControl(username: String?, email: String?) {
        if(username.toString().equals(Constants.USERNAME) || email.toString().equals(Constants.EMAIL)){
            Snackbar.make(binding.signUpLayout, resources.getString(R.string.toastRegisteredUser), Snackbar.LENGTH_LONG)
                .setAction("Login") {
                    loginActivity()
                }
                .show()
        }
        else{
            Toast.makeText(this@SignUpActivity, resources.getString(R.string.toastRegistrationSuccessful), Toast.LENGTH_LONG).show()
        }
    }

    private fun loginActivity() {
        val loginIntent = Intent(this@SignUpActivity, LoginActivity::class.java)
        startActivity(loginIntent)
        finish()
    }
}