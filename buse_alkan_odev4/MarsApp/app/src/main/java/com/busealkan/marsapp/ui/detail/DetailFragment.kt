package com.busealkan.marsapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.busealkan.marsapp.R
import com.busealkan.marsapp.databinding.FragmentDetailBinding
import com.busealkan.marsapp.loadFromUrl
import com.busealkan.marsapp.ui.categories.CategoriesFragmentDirections
import com.busealkan.marsapp.util.Constants

class DetailFragment : Fragment() {

    private lateinit var fragmentDetailBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater)

        //eğer gelen argüman var ise key isimlendirmelerine göre değişkenlere atanır.
        arguments?.let {
            val bundle: DetailFragmentArgs by this.navArgs()
            val id = bundle.marsModelItem.id
            val type = bundle.marsModelItem.type
            val imgSrc = bundle.marsModelItem.img_src
            val price = bundle.marsModelItem.price.toString()

            fragmentDetailBinding.apply{
                //ui kısmında değişiklikler yapılır.

                imgDetailMars.loadFromUrl(imgSrc)
                txtMarsId.text = id
                txtDetailPrice.text = price
                txtDetailType.text = type.capitalize()

                /*
                    type değişkeni Constantsta bulunan değişkenler ile aynı olup olmadığı kontrol edilerek
                    imgMarsType drawable değiştirilir.
                */
                if(type==Constants.TYPE_BUY){
                    imgMarsType.setBackgroundResource(R.drawable.buy)
                }
                else{
                    imgMarsType.setBackgroundResource(R.drawable.rent)
                }

                /*
                    imgBackButton butonuna tıklandığında
                    findNavController ile DetailFragmentten ListFragmente action oluşturulur.
                    type değişkeni ListFragmente argüman olarak gönderilir.
                 */
                imgBackButton.setOnClickListener {
                    val args = DetailFragmentDirections.actionDetailFragmentToListFragment(type).arguments
                    findNavController().navigate(R.id.action_detailFragment_to_listFragment, args)
                }
            }
        }
        return fragmentDetailBinding.root
    }
}