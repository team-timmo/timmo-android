package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.databinding.ActivityLoginMainBinding

class LoginMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            Log.d("hello", "buttonstart")
            val intent = Intent(this, SignUpActivity1::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }

        binding.buttonLogin.setOnClickListener {
            Log.d("hello", "buttonLogin")
            val intent = Intent(this, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }
}
