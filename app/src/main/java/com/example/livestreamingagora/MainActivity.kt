package com.example.livestreamingagora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {


    var userRole = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA , android.Manifest.permission.RECORD_AUDIO), 22)
    }

    fun onSubmit(view: View){
        val channelName = findViewById<View>(R.id.channel) as EditText
        val userRadioButton = findViewById<View>(R.id.radio_group) as RadioGroup

        val checked = userRadioButton.checkedRadioButtonId
        val audienceButtonId = findViewById<View>(R.id.audience_rb) as RadioButton

        userRole = if (checked == audienceButtonId.id) 0 else 1

        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("ChannelName", channelName.text.toString())
        intent.putExtra("UserRole", userRole)
        startActivity(intent)

    }
}