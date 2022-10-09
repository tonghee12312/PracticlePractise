package com.example.set7heechintongrsd2g3

import android.content.ClipData.newIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.example.set7heechintongrsd2g3.databinding.ActivityMainBinding
import java.util.jar.Manifest


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
            val age = getAge()
            val Year = getYear()
            val income =binding.spinnertaxIncome.selectedItemPosition

            var rate15 =0
            var rate16 =0

            when(binding.spinnertaxIncome.selectedItemPosition){

            }
            if(name.isEmpty()){
                binding.editTextName.error = getString(R.string.noname)
                return@setOnClickListener
            }


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
        binding.radioGroupAge.check(R.id.radioButtonUnderAge)
        binding.spinnertaxIncome.setSelection(0)
        binding.radioGroupYear.check(R.id.radioButtonYear2015)
    }

    private fun getYear(): String {
        return when(binding.radioGroupYear.checkedRadioButtonId){
            R.id.radioButtonYear2015 -> getString(R.string._2015)
            R.id.radioButtonyear2016 -> getString(R.string._2016)
            else ->""
        }

    }

    private fun checkPermissions() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 101)
        }
        }
    private fun getAge(): String {
        return when(binding.radioGroupAge.checkedRadioButtonId) {
            R.id.radioButtonUnderAge -> getString(R.string.aboveAge)
            R.id.radioButtonAboveAge -> getString(R.string.belowAge)
            else -> ""
        }
    }

}
