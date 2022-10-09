package com.example.set7heechintongrsd2g3

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.example.set7heechintongrsd2g3.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reset()

        checkPermissions()

        binding.buttonReset.setOnClickListener {
            reset()
        }
        binding.buttonCalculate.setOnClickListener{
            val name = binding.editTextName.toString()
            val age = binding.spinnerAge.selectedItemPosition
            val income =binding.editTextIncome.text.toString().toDoubleOrNull()

            if(name.isEmpty()) {
                binding.editTextName.error = getString(R.string.noname)
                return@setOnClickListener
            }

            if(income == null) {
                binding.editTextIncome.error = getString(R.string.rm)
                return@setOnClickListener
            }

            var rate15 =0
            var rate16 =0

            when(income){
                    in 0.0..5000.0 -> {
                    }
                    in 5001.0..20000.0 -> {
                        rate15 = 1
                        rate16 = 1
                    }
                    in 20001.0..35000.0 -> {
                        rate15 = 6
                        rate16 = 5
                    }
                    else -> {
                        rate15 = 11
                        rate16 = 10
                    }
                }
            var incometax2015 = income * (rate15.toFloat()/100)
            var incometax2016 = income * (rate16.toFloat()/100)
            var incomeresult = String.format(getString(R.string.resultMessage), name)

            if(age == 0){
                incometax2015 -= 300
                incometax2016 -= 300
                incomeresult += getString(R.string.underage)
            }
            incomeresult += if(incometax2015 <= 0 || incometax2016 <= 0){
                getString(R.string.notax)
            }else{
                String.format(getString(R.string.Showresult), rate15, rate16, incometax2015, incometax2016)
            }

            binding.textViewResultShow.text = incomeresult
        }








        binding.buttonphonecall.setOnClickListener {
            val phone = Intent(
                Intent.ACTION_CALL,
                Uri.parse("tel:0383138888")
            )
            startActivity(phone)
        }
            binding.buttonWebsite.setOnClickListener {
                val web = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.hasil.gov.my/")
                )
                startActivity(web)
            }

        }

    private fun reset() {
        binding.editTextName.text.clear()
        binding.spinnerAge.setSelection(0)
        binding.editTextIncome.text.clear()
    }


    private fun checkPermissions() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 101)
        }
        }

}


