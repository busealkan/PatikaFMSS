package com.busealkan.marsapp.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.busealkan.marsapp.R
import com.busealkan.marsapp.databinding.FragmentCategoriesBinding
import com.busealkan.marsapp.databinding.FragmentSplashBinding
import com.busealkan.marsapp.ui.list.ListFragmentDirections
import com.busealkan.marsapp.util.Constants

class CategoriesFragment : Fragment() {

    private lateinit var fragmentCategoriesBinding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCategoriesBinding = FragmentCategoriesBinding.inflate(layoutInflater)
        return fragmentCategoriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentCategoriesBinding.apply {
            //btnRent butonuna tıklandığında typeSelect fonksyionu çağrılır ve parametre olarak "rent" değeri verilir.
            btnRent.setOnClickListener {
                typeSelect(Constants.TYPE_RENT)
            }

            //btnBuy butonuna tıklandığında typeSelect fonksyionu çağrılır ve parametre olarak "buy" değeri verilir.
            btnBuy.setOnClickListener {
                typeSelect(Constants.TYPE_BUY)
            }
        }
    }

    /*
        findNavController ile CategoriesFragmentten ListFragmente action oluşturulur.
        fonksiyona parametre olarak gelen type değişkeni ListFragmente argüman olarak gönderilir.
     */
    private fun typeSelect(type: String) {
        val args =
            CategoriesFragmentDirections.actionCategoriesFragmentToListFragment(type).arguments
        findNavController().navigate(R.id.action_categoriesFragment_to_listFragment, args)
    }
}