package com.github.tumusx.gistapiapp.presenter.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.tumusx.gistapiapp.databinding.ActivityMainBinding
import com.github.tumusx.gistapiapp.presenter.view.fragment.GistFavoriteFragment
import com.github.tumusx.gistapiapp.presenter.view.fragment.GistListFragment
import com.github.tumusx.gistapiapp.utils.DialogUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        configListeners()
        redirectUser()
        setContentView(binding.root)
    }


    private fun redirectUser() {
        val connectivityManager: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: Network? = connectivityManager.activeNetwork
        if (networkInfo != null) {
            configFragments()
        } else {
            createDialog()
        }
    }

    private fun createDialog() {
        DialogUtil.showDialogToUser(this) {
            supportFragmentManager.beginTransaction()
                .replace(binding.myFragmentTypeInflate.id, GistFavoriteFragment()).commit()
        }
    }

    private fun configFragments() {
        supportFragmentManager.beginTransaction()
            .add(binding.myFragmentTypeInflate.id, GistListFragment()).commit()
    }

    private fun configListeners() {
        binding.txtFavoriteUser.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.myFragmentTypeInflate.id, GistFavoriteFragment()).commit()
        }
    }
}