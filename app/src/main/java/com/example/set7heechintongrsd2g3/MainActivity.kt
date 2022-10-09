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
        checkPermissions()

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

    private fun checkPermissions() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 101)
        }
    }


}
