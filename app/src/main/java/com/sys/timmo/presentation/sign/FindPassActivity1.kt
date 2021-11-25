package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.R
import com.sys.timmo.databinding.ActivityFindPass1Binding
import com.sys.timmo.databinding.ActivitySignInBinding

class FindPassActivity1 : AppCompatActivity() {
    private lateinit var binding : ActivityFindPass1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPass1Binding.inflate(layoutInflater)
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

        binding.buttonNext.setOnClickListener {
            val intent = Intent(this, FindPassActivity2::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }

    private fun EnableButton(binding: ActivityFindPass1Binding) {
        val email = binding.editTextEmail.text.toString()

        if (email.isNotEmpty() && isEmailFormat(email)) {
            binding.buttonNext.setBackgroundResource(R.drawable.selector_purple_radius_10_button)
            binding.buttonNext.isEnabled = true
        }
        else {
            binding.buttonNext.setBackgroundResource(R.drawable.selector_radius_10_button)
            binding.buttonNext.isEnabled = false
        }
    }

    private fun isEmailFormat(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
