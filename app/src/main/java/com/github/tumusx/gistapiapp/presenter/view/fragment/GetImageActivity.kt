package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.tumusx.gistapiapp.databinding.GetFileWebBinding
import com.github.tumusx.gistapiapp.utils.ConstUtils

class GetImageActivity : AppCompatActivity() {
    private lateinit var binding: GetFileWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GetFileWebBinding.inflate(layoutInflater)
        loadFileInWebView()
        setContentView(binding.root)
    }

    private fun loadFileInWebView() {
        val getUrlRawFile = intent.getStringExtra(ConstUtils.SEND_URL_WEBVIEW)
        getUrlRawFile?.replace("[", "")
        getUrlRawFile?.replace("]", "")
        if (getUrlRawFile != null) binding.webView.loadUrl("https://gist.githubusercontent.com/choco-bot/9a6d2ac1312c136d5658aa8546e7e29f/raw/68f82e8042339073883ed2d29624d4cc251570f9/FilesSnapshot.xml,%20https://gist.githubusercontent.com/choco-bot/9a6d2ac1312c136d5658aa8546e7e29f/raw/afd78b4b4613fed865b153bdaa7f7fef4c10a368/Install.txt,%20https://gist.githubusercontent.com/choco-bot/9a6d2ac1312c136d5658aa8546e7e29f/raw/64a5505d4f9206ce28f4c70fbf6e19f518a9cc59/Uninstall.txt,%20https://gist.githubusercontent.com/choco-bot/9a6d2ac1312c136d5658aa8546e7e29f/raw/fed851c6101e6c402aa4aa64e0ddf53e440e554e/_Summary.md")
    }
}