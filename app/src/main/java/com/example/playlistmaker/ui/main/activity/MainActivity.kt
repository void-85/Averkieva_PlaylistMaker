package com.example.playlistmaker.ui.main.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playlistmaker.ui.search.activity.SearchingActivity
import com.example.playlistmaker.ui.settings.activity.SettingsActivity
import com.example.playlistmaker.databinding.ActivityMainBinding
import com.example.playlistmaker.ui.mediateka.activity.MediatekaActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.search.setOnClickListener {
            navigateTo(SearchingActivity::class.java)
        }

        binding.media.setOnClickListener {
            navigateTo(MediatekaActivity::class.java)
        }

        binding.settings.setOnClickListener {
            navigateTo(SettingsActivity::class.java)
        }

    }

    private fun navigateTo(classes: Class<out AppCompatActivity>) {
        val intent = Intent(this, classes)
        startActivity(intent)
    }
}