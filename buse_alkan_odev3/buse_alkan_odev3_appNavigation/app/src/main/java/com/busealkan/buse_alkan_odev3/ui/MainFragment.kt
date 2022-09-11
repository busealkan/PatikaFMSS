package com.busealkan.buse_alkan_odev3_appNavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.busealkan.buse_alkan_odev3_appNavigation.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var fragmentMainBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMainBinding = FragmentMainBinding.inflate(inflater)
        return fragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
          eğer gelen argüman var ise key isimlendirmelerine göre değişkenlere atanır ve txtWelcome textinde ekranda gösterilir.
         */
        arguments?.let {
            val username = arguments?.getString("username")
            val password = arguments?.getString("password")
            fragmentMainBinding.txtWelcome.text = "Hoş Geldiniz "+ username
        }
    }
}