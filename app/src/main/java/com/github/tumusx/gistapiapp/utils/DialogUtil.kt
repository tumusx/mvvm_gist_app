package com.github.tumusx.gistapiapp.utils

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.github.tumusx.gistapiapp.R

object DialogUtil {
    fun showDialogToUser(context: AppCompatActivity, callback: (Any)-> Unit) {
        val builderDialog = AlertDialog.Builder(context)
        builderDialog.setTitle(context.getString(R.string.not_connection))
        builderDialog.setPositiveButton(context.getString(R.string.go_to_favorite)) { _, _ ->
            callback.invoke(true)
        }
        val dialog: AlertDialog = builderDialog.create()
        dialog.show()
    }
}