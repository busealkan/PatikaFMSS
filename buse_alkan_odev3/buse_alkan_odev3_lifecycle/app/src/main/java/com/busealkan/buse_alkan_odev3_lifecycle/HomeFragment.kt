package com.busealkan.buse_alkan_odev3_lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.busealkan.buse_alkan_odev3_lifecycle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.v("BuseAlkan", "onAttach called.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v("BuseAlkan", "onCreate called.")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root

        Log.v("BuseAlkan", "onCreateView called.")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("BuseAlkan", "onViewCreated called.")


        fragmentHomeBinding.apply {
            //btnPrint'e tıklandığında txtName textini edtTxtName textine yazdırılır.
            btnPrint.setOnClickListener {
                txtName.setText(edtTxtName.text)
            }
        }
    }

    /*
        Eğer savedInstanceState boş değil ise onSaveInstanceState metotu içerisinde kaydedilen değerler key(name) ile alınarak getName değişkenine atanır
        ve txtName textine getName değişkenine yazdırılır.
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        Log.v("BuseAlkan", "onViewStateRestored called.")

        savedInstanceState?.let{
            val getName = savedInstanceState.getString("name")
            fragmentHomeBinding.txtName.setText(getName)
        }
    }

    override fun onStart() {
        super.onStart()

        Log.v("BuseAlkan", "onStart called.")
    }

    override fun onResume() {
        super.onResume()

        Log.v("BuseAlkan", "onResume called.")
    }

    override fun onPause() {
        super.onPause()

        Log.v("BuseAlkan", "onPause called.")
    }

    override fun onStop() {
        super.onStop()

        Log.v("BuseAlkan", "onStop called.")
    }

    /*
        txtName textini name değişkenine atanır.
        Ekran yönü değiştirildiğinde saklanmasını istediğimiz veriler key(name) value(nameText) şeklinde outState içerisinde saklanır.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.v("BuseAlkan", "onSaveInstanceState called.")

        val nameText = fragmentHomeBinding.txtName.text.toString()
        outState.putString("name", nameText)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.v("BuseAlkan", "onDestroyView called.")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.v("BuseAlkan", "onDestroy called.")
    }

    override fun onDetach() {
        super.onDetach()

        Log.v("BuseAlkan", "onDetach called.")
    }

}