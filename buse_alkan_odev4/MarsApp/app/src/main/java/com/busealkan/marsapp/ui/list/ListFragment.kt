package com.busealkan.marsapp.ui.list

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.busealkan.marsapp.R
import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.databinding.FragmentListBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.busealkan.marsapp.ItemClickListener
import com.busealkan.marsapp.util.AlertUtil
import com.busealkan.marsapp.util.Constants
import com.busealkan.marsapp.util.ProgressUtil

class ListFragment : Fragment() {

    private lateinit var fragmentListBinding: FragmentListBinding
    private var listViewModel: ListViewModel? = null
    private lateinit var listAdapter: ListAdapter
    private var marsList: List<MarsModelItem>? = null
    private var progressDialog: ProgressDialog? = null
    private var type: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListBinding = FragmentListBinding.inflate(layoutInflater)
        return fragmentListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //eğer gelen argüman var ise key isimlendirmelerine göre type değişkenine atanır.
        arguments?.let {
            val bundle: ListFragmentArgs by this.navArgs()
            type = bundle.type
        }

        /*
            txtMarsRealestate texti değiştirilir.
            Progress Dialog oluşturulur.
            btnSortBy butonuna tıklandığında alertList() fonksiyonu çağrılır.
            initViewModel fonksiyonu çağrılarak parametre olarak type(buy-rent) değişkeni gönderilir.
         */
        fragmentListBinding.apply {
            txtMarsRealestate.text = type!!.toString().capitalize() + " Mars"
            progressDialog = ProgressUtil.progressDialogCreate(
                context,
                resources.getString(R.string.progressMessage),
                R.style.AlertDialogTheme
            )!!

            btnSortBy.setOnClickListener {
                alertList()
            }
        }
        initViewModel(type!!)
    }

    /*
        listViewModel değişkenine ListViewModel ataması yapılacak ve ListViewModelde live
        datalar dinlenerek durumlarına göre işlem yapılcaktır
     */
    private fun initViewModel(type: String) {
        listViewModel = ListViewModel()

        listViewModel?.apply {

            marsLiveData?.observe(viewLifecycleOwner, Observer {

                it.run {
                    /*
                        marsList değişkenine it ataması yapılırak initRecyleView fonksiyonu çağrılarak
                        parametre olarak list buy veya rent tipine före filtrelenerek gönderilir
                        progress dialog kapatılır.
                     */
                    marsList = it
                    initRecycleView(it.filter { it.type.contains(type) })
                    ProgressUtil.progressDialogClose(progressDialog)
                }
            })

            error?.observe(viewLifecycleOwner, Observer {

                it.run {
                }
            })

            loading?.observe(viewLifecycleOwner, Observer {

                //Handle loading
            })
        }
    }

    private fun initRecycleView(marsList: List<MarsModelItem>?) {
        fragmentListBinding.apply {
            listAdapter = ListAdapter(marsList!!, object : ItemClickListener {
                /*
                    Listelenen card viewe tıklandığında mars değişkenine tıklanan card
                    viewin positonu atanır.

                    findNavController ile ListFragmentten DetailFragmente action oluşturulur.
                    mars değişkeni ListFragmente argüman olarak gönderilir.
                 */
                override fun onItemClick(position: Int) {
                    val mars: MarsModelItem = marsList.get(position)
                    val args =
                        ListFragmentDirections.actionListFragmentToDetailFragment(mars).arguments
                    findNavController().navigate(R.id.action_listFragment_to_detailFragment, args)
                }
            })
            /*
                rcvMars adaptörüne listAdapter atanır.
                rcvMars ekranda görüntüsü staggered grid 2 adet kullanılarak oluşturulur.
             */
            rcvMars.adapter = listAdapter
            rcvMars.layoutManager = StaggeredGridLayoutManager(
                Constants.SPAN_COUNT,
                StaggeredGridLayoutManager.VERTICAL
            )
        }
    }

    /*
        Alert List Dialog göstlerilir.
        ItemClickListener interface ile Alert Utilden gelen pozisyonun kontrolü yapılarak listeleme işlemi yapılır.
     */
    private fun alertList() {
        val sortBy = arrayOf("Price, low to high", "Price, high to low")

        AlertUtil.alertListShow(context as Activity,
            resources.getString(R.string.sortBy),
            sortBy,
            R.style.AlertListDialogTheme,
            resources.getDrawable(R.drawable.sort),
            object : ItemClickListener {
                override fun onItemClick(position: Int) {
                    var typeListFiltre: List<MarsModelItem>? = null

                    if (position == AlertUtil.AlertListDialogSelected.ASCENDING_SORT.alertValue) {
                        marsList?.let {
                            typeListFiltre = it.sortedBy { it.price }
                        }
                    } else if (position == AlertUtil.AlertListDialogSelected.DESCENDING_SORT.alertValue) {
                        marsList?.let {
                            typeListFiltre = it.sortedByDescending { it.price }
                        }
                    }

                    if (!typeListFiltre.isNullOrEmpty()) {
                        listAdapter.setData(typeListFiltre!!)
                        listAdapter.notifyDataSetChanged()
                    }

                }
            })
    }
}
