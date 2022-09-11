package com.busealkan.buse_alkan_odev3_appNavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.busealkan.buse_alkan_odev3_appNavigation.R
import com.busealkan.buse_alkan_odev3_appNavigation.databinding.FragmentLoginBinding
import com.busealkan.buse_alkan_odev3_appNavigation.util.Constants

class LoginFragment : Fragment() {

    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
        return fragmentLoginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding.apply {
            //btnLogin'e tıklandığında nullCheck() fonsksiyonu çağrılır.
            btnLogin.setOnClickListener {
                nullCheck()
            }
        }
    }

    /*
        txtUsername değeri username adında değişkene atanır.
        txtPassword değeri password adında değişkene atanır.
        username ve password değişkenlerinin eğer boş ise toast ile uyarı mesajı gösterilir., boş değil ise userControl fonksiyonu çağrılır.
     */
    private fun nullCheck() {
        var username = fragmentLoginBinding.txtUsername.text.toString().trim()
        var password = fragmentLoginBinding.txtPassword.text.toString().trim()

        if (username.equals(resources.getString(R.string.nullCheck)) || password.equals(resources.getString(R.string.nullCheck))) {
            Toast.makeText(context, resources.getString(R.string.toastNullField), Toast.LENGTH_SHORT).show()
        } else {
            userControl(username, password)
        }
    }

    /*
        parametre olarak gelen username ve password değişkenleri Constantsta bulunan değerler ile eşleşiyor ise
        username ve password değişkenleri MainFragment'e argüman olarak gönderilir,

        findNavController ile LoginFragmentten MainFragmente action oluşturulur.
        LoginFragment arka yığından çıkması için setPopUpTo(destinationId: Int, inclusive:boolean) kullanılmıştır.

        destinationId = Araya giren tüm varış yerlerini temizleyerek hedefi açar.
        inclusive: true = Verilen hedefi arka yığından çıkarmak için.

        eğer değişkenler Constantsta bulunan değişkenler ile eşleşmiyor ise toast ile uyarı mesajı gösterilir.
     */
    private fun userControl(username: String?, password: String?) {
        if (username.toString().equals(Constants.USERNAME) && password.toString().equals(Constants.PASSWORD)) {
            val args = LoginFragmentDirections.actionLoginFragmentToMainFragment(password!!,username!!).arguments
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment, args, NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build())
        } else {
            Toast.makeText(context, resources.getString(R.string.toastLoginFailed), Toast.LENGTH_SHORT).show()
        }
    }
}
