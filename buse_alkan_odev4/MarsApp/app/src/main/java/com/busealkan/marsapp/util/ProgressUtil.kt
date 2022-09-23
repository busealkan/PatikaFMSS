package com.busealkan.marsapp.util

import android.app.ProgressDialog
import android.content.Context

object ProgressUtil {
    /*
        Fonksiyon çağrıldığında progress dialogun hangi
        sayfada gözükeceği, mesajının ne olacağı bilgileri parametre olarak verilmiştir.
        Progress Dialogun oluşturulup gösterilmesini sağlar.
     */
    fun progressDialogCreate(
        context: Context?,
        message: CharSequence?,
        style: Int
    ): ProgressDialog? {
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage(message)
        progressDialog.show()
        progressDialog.setProgressStyle(style)
        return progressDialog
    }

    //Eğer progress dialog boş değilse ve gösterildiyse dialogu kapatır.
    fun progressDialogClose(progressDialog: ProgressDialog?) {
        if (progressDialog != null && progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}