package com.sys.timmo.presentation.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.databinding.ActivitySignUp8Binding

class SignUpActivity8 : AppCompatActivity() {
    private lateinit var binding: ActivitySignUp8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp8Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}