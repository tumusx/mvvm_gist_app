package com.github.tumusx.gistapiapp.presenter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.tumusx.gistapiapp.databinding.GetFileWebBinding
import com.github.tumusx.gistapiapp.utils.ConstUtils
import com.google.android.material.snackbar.Snackbar

class OpenFileActivity : AppCompatActivity() {
    private lateinit var binding: GetFileWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GetFileWebBinding.inflate(layoutInflater)
        loadFileInWebView()
        configListeners()
        setContentView(binding.root)
    }

    private fun loadFileInWebView() {
        val getUrlRawFile = intent.getStringExtra(ConstUtils.SEND_URL_WEBVIEW)
        if (getUrlRawFile != null)
            binding.webView.loadUrl(getUrlRawFile)
        else
            Snackbar.make(binding.webView, "error to load", Snackbar.LENGTH_SHORT).show()
    }

    private fun configListeners(){
        binding.back.setOnClickListener { onBackPressed() }
    }
}