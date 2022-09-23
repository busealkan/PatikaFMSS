package com.busealkan.marsapp.ui.splash

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.busealkan.marsapp.R
import com.busealkan.marsapp.databinding.FragmentSplashBinding
import com.busealkan.marsapp.util.AlertUtil
import com.busealkan.marsapp.util.NetworkUtil

class SplashFragment : Fragment() {

    private lateinit var fragmentSplashBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSplashBinding = FragmentSplashBinding.inflate(layoutInflater)
        return fragmentSplashBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
            eğer networkController() fonksyionundan dönen değer true ise btnLetsGo butonuna tıklandığında categoriesFragment() fonsksiyonu çağrılır.
            dönen değer false ise internetAlert() fonksyionu çağrılır
         */
        if (networkController() == true) {
            fragmentSplashBinding.btnLetsGo.setOnClickListener {
                categoriesFragment()
            }
        } else {
            internetAlert()
        }
    }

    /*
        NetworkUtildeki isThereInternet fonksiyonuna bulunulan contexti parametre olarak gönderir.
        Ve eğer internet var ise true değeri döndürülür.
        İnternet yok ise false değeri döndürülür.
     */
    private fun networkController(): Boolean {
        if (context?.let { NetworkUtil.isThereInternet(it) } == true) {
            return true
        } else {
            return false
        }
    }

    //Alert Dialog gösterilmesini sağlar.
    private fun internetAlert() {
        AlertUtil.alertDialogShow(
            context as Activity,
            R.style.AlertDialogTheme,
            resources.getDrawable(R.drawable.interneticon),
            resources.getString(R.string.alertTitle),
            resources.getString(R.string.alertMessage),
            resources.getString(R.string.alertNegativeButton),
            resources.getString(R.string.alertPositiveButton),
            AlertUtil.AlertDialogSelected.INTERNET
        )
    }

    /*
        findNavController ile SplashFragmentten CategoriesFragmente action oluşturulur.
        SplashFragmentten arka yığından çıkması için setPopUpTo(destinationId: Int, inclusive:boolean) kullanılmıştır.

        destinationId = Araya giren tüm varış yerlerini temizleyerek hedefi açar.
        inclusive: true = Verilen hedefi arka yığından çıkarmak için.

     */
    private fun categoriesFragment() {
        findNavController().navigate(
            R.id.action_splashFragment_to_categoriesFragment,
            null,
            NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
        )
    }
}