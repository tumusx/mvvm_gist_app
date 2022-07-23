package com.github.tumusx.gistapiapp.presenter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.tumusx.gistapiapp.databinding.ActivityMainBinding
import com.github.tumusx.gistapiapp.presenter.view.fragment.GistListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        configFragments()
        setContentView(binding.root)
    }

    private fun configFragments() {
        val gistListFragment = GistListFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.myFragmentTypeInflate.id, gistListFragment).commit()
    }
}

enum class FragmentType {
    LIST_FRAGMENT,
    FAVORITE_FRAGMENT
}