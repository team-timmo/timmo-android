package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.sys.timmo.MainActivity
import com.sys.timmo.R
import com.sys.timmo.databinding.ActivitySignInBinding
import com.sys.timmo.databinding.ActivitySignUp1Binding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                EnableButton(binding)
            }
        })

        binding.editTextPassword.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                EnableButton(binding)
            }
        })

        binding.buttonCheck.setOnClickListener {
            val intent = Intent(this, LoginMainActivity::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }

        binding.textViewForgetPassword.setOnClickListener {
            val intent = Intent(this, FindPassActivity1::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }

    private fun EnableButton(binding: ActivitySignInBinding) {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty() && isEmailFormat(email) && isPasswordFormat(password)) {
            binding.buttonCheck.setBackgroundResource(R.drawable.selector_purple_radius_10_button)
            binding.buttonCheck.isEnabled = true
        }
        else {
            binding.buttonCheck.setBackgroundResource(R.drawable.selector_radius_10_button)
            binding.buttonCheck.isEnabled = false
        }
    }

    private fun isEmailFormat(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordFormat(password: String): Boolean {
        return password.matches("^[a-zA-Z0-9].{6,15}\$".toRegex())
    }
}
