package com.example.tictactoe

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> AppCompatActivity.activityViewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

