package com.example.mavlianov_hw6_month3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mavlianov_hw6_month3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnGmail.setOnClickListener {
            shareText()
        }
    }

    private fun shareText() {
        val emailBody = viewBinding.editTextId.text.toString()

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Тема")
            putExtra(Intent.EXTRA_TEXT, emailBody)
        }

        try {
            startActivity(Intent.createChooser(shareIntent, "Поделитесь текстом через"))
        } catch (e: Exception) {
            Toast.makeText(this, "Нет доступных приложений для отправки", Toast.LENGTH_LONG).show()
        }
    }
}
