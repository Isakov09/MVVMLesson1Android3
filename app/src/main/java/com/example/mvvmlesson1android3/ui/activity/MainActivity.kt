package com.example.mvvmlesson1android3.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.mvvmlesson1android3.R
import com.example.mvvmlesson1android3.databinding.ActivityMainBinding
import com.example.mvvmlesson1android3.preference.UserPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userPreferences = UserPreferences(this)
        val navController = findNavController(R.id.fragment_container)

        if (!userPreferences.isRegistered()) {

            navController.navigate(R.id.signFragment2)
        } else {

            navController.navigate(R.id.homeFragment2)
        }
    }
}