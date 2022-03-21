package com.sys.timmo.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.sys.timmo.R
import com.sys.timmo.databinding.ActivitySignUp4Binding

class SignUpActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivitySignUp4Binding
    var sidoUserSelected = ""
    var spinnerSigungu = R.array.seoul_sigungu
    var sigunguUserSelected = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSpinnerSido()
        setupSpinnerSidoHandler()
        binding.buttonCompletion.isEnabled = true

        binding.buttonCompletion.setOnClickListener {
            val intent = Intent(this, LoginMainActivity::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
            )
            startActivity(intent)
            finish()
        }
    }

    private fun setUpSpinnerSido() {
        val sidos = resources.getStringArray(R.array.sido)
        val sidoAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sidos)
        binding.spinnerSido.adapter = sidoAdapter
    }

    private fun setupSpinnerSidoHandler() {
        binding.spinnerSido.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                sidoUserSelected = binding.spinnerSido.selectedItem.toString()
                // 시도 다음 넘기기
                changeSigunguPerSido(position)
                setUpSpinnerSigungu()
                setupSpinnerSigunguHandler()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun changeSigunguPerSido(position: Int) {
        when (position) {
            0 -> spinnerSigungu = R.array.gangwon_sigungu
            1 -> spinnerSigungu = R.array.gyeongi_sigungu
            2 -> spinnerSigungu = R.array.gyeongnam_sigungu
            3 -> spinnerSigungu = R.array.gyeongbuk_sigungu
            4 -> spinnerSigungu = R.array.gwangju_sigungu
            5 -> spinnerSigungu = R.array.daegu_sigungu
            6 -> spinnerSigungu = R.array.daejeon_sigungu
            7 -> spinnerSigungu = R.array.busan_sigungu
            8 -> spinnerSigungu = R.array.seoul_sigungu
            9 -> spinnerSigungu = R.array.sejong_sigungu
            10 -> spinnerSigungu = R.array.ulsan_sigungu
            11 -> spinnerSigungu = R.array.incheon_sigungu
            12 -> spinnerSigungu = R.array.jeonnam_sigungu
            13 -> spinnerSigungu = R.array.jeonbuk_sigungu
            14 -> spinnerSigungu = R.array.jeju_sigungu
            15 -> spinnerSigungu = R.array.chungnam_sigungu
            16 -> spinnerSigungu = R.array.chungbuk_sigungu
        }
    }

    private fun setUpSpinnerSigungu() {
        val sigungus = resources.getStringArray(spinnerSigungu)
        val sigunguAdapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, sigungus)
        binding.spinnerSigungu.adapter = sigunguAdapter
    }

    private fun setupSpinnerSigunguHandler() {
        binding.spinnerSigungu.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    sigunguUserSelected = binding.spinnerSigungu.selectedItem.toString()
                    // 시군구 다음 넘기기
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
    }
}
