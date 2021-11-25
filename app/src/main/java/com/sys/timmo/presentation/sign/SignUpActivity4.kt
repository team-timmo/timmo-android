package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.databinding.ActivitySignUp4Binding

class SignUpActivity4 : AppCompatActivity() {
    private lateinit var binding : ActivitySignUp4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCompletion.setOnClickListener {
            val intent = Intent(this, LoginMainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }
}
