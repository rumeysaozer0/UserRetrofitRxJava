package com.rumeysaozer.retrofitusers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rumeysaozer.retrofitusers.databinding.ActivityDetailsBinding
import com.rumeysaozer.retrofitusers.databinding.ActivityMainBinding
import com.rumeysaozer.retrofitusers.model.UserItem

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = intent
        val selectedUser = intent.getSerializableExtra("user") as UserItem
        binding.email.text = selectedUser.email
        binding.gender.text = selectedUser.gender
        binding.name.text = selectedUser.name
        binding.status.text = selectedUser.status
    }
}