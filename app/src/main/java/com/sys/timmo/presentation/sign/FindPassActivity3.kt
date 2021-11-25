package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.R
import com.sys.timmo.databinding.ActivityFindPass2Binding
import com.sys.timmo.databinding.ActivityFindPass3Binding
import com.sys.timmo.databinding.ActivitySignUp1Binding

class FindPassActivity3 : AppCompatActivity() {
    private lateinit var binding : ActivityFindPass3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPass3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextPassword.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                EnableButton(binding)
            }
        })

        binding.editTextPasswordCheck.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                EnableButton(binding)
            }
        })

        binding.buttonCompletion.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }

    private fun EnableButton(binding: ActivityFindPass3Binding) {
        val password = binding.editTextPassword.text.toString()
        val passwordcheck = binding.editTextPasswordCheck.text.toString()

        if (password.isNotEmpty() && isPasswordFormat(password) && password.equals(passwordcheck)) {
            binding.buttonCompletion.setBackgroundResource(R.drawable.selector_purple_radius_10_button)
            binding.buttonCompletion.isEnabled = true
        }
        else {
            binding.buttonCompletion.setBackgroundResource(R.drawable.selector_radius_10_button)
            binding.buttonCompletion.isEnabled = false
        }
    }

    private fun isPasswordFormat(password: String): Boolean {
        return password.matches("^[a-zA-Z0-9].{6,15}\$".toRegex())
    }
}
