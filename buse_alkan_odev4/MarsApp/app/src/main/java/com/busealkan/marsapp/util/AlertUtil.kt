package com.busealkan.marsapp.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.provider.Settings
import com.busealkan.marsapp.ItemClickListener

//Static AlertUtil adında bir obje oluşturulmuştur.
object AlertUtil {

    /*
        Alert Dialogun hangi activityde gözükeceği, stili, iconu, title, message ve butonlarında ne yazacağı ve
        AlertDialogSelected enumında seçilen değer çağrıldığı yerde parametre olarak gönderilerek oluşturulur.
     */
    fun alertDialogShow(
        activity: Activity,
        style: Int,
        icon: Drawable?,
        title: CharSequence?,
        message: CharSequence?,
        negativeButton: CharSequence?,
        positiveButton: CharSequence?,
        alertSelected: AlertDialogSelected
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity, style)
        builder.setIcon(icon)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setNegativeButton(negativeButton,
            DialogInterface.OnClickListener { dialog, which ->
                if (alertSelected.equals(AlertDialogSelected.INTERNET)) {
                    activity.finish()
                } else {
                    activity.finish()
                }
            })
        builder.setPositiveButton(positiveButton,
            DialogInterface.OnClickListener { dialog, which ->
                if (alertSelected.equals(AlertDialogSelected.INTERNET)) {
                    dialog.dismiss()
                    activity.startActivity(Intent(Settings.ACTION_SETTINGS))
                    activity.finish()
                } else {
                    dialog.dismiss()
                }
            })
        builder.show()
    }

    fun alertListShow(
        activity: Activity,
        title: String,
        listSortBy: Array<String>,
        style: Int,
        icon: Drawable?,
        callback: ItemClickListener
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity, style)
        builder.setTitle(title)
        builder.setIcon(icon)

        /*
            Tıklandığında gözükecek itemler set edilmiştir.
            Ve pozisyon callback edilecektir.
         */
        builder.setItems(listSortBy) { dialog, pozisyon ->
            callback.onItemClick(pozisyon)
        }

        val dialog = builder.create()
        dialog.show()
    }

    //Alert dialog kullanımında hangi ekranda hangi alert dialogun gösterilmesini kontrol edebilmek için kullanılmıştır.
    enum class AlertDialogSelected {
        INTERNET,
        EXIT
    }

    //Alert list dialog kullanımında dialog item pozisyonunu kontrol edebilmek için kullanılmıştır.
    enum class AlertListDialogSelected(val alertValue: Int) {
        ASCENDING_SORT(Constants.ASCENDING_SORT),
        DESCENDING_SORT(Constants.DESCENDING_SORT)
    }
}




