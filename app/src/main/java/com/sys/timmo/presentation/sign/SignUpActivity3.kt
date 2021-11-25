package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.R
import com.sys.timmo.databinding.ActivitySignInBinding
import com.sys.timmo.databinding.ActivitySignUp3Binding

class SignUpActivity3 : AppCompatActivity() {
    private lateinit var binding : ActivitySignUp3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextNickname.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                EnableButton(binding)
            }
        })

        binding.buttonNext.setOnClickListener {
            val intent = Intent(this, SignUpActivity4::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }

    private fun EnableButton(binding: ActivitySignUp3Binding) {
        val nickname = binding.editTextNickname.text

        if (nickname.length > 1) {
            binding.buttonNext.setBackgroundResource(R.drawable.selector_purple_radius_10_button)
            binding.buttonNext.isEnabled = true
        }
        else {
            binding.buttonNext.setBackgroundResource(R.drawable.selector_radius_10_button)
            binding.buttonNext.isEnabled = false
        }
    }
}
