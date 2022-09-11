package com.busealkan.buse_alkan_odev2.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.drawable.Drawable


object AlertUtil {
    fun alertDialogShow(activity: Activity, style: Int, icon: Drawable?, title: CharSequence?, message: CharSequence?, negativeButton: CharSequence?, positiveButton: CharSequence?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity, style)
        builder.setIcon(icon)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setNegativeButton(negativeButton,
            DialogInterface.OnClickListener { dialog, which ->
                activity.finish()
            })
        builder.setPositiveButton(positiveButton,
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        builder.show()
    }
}




