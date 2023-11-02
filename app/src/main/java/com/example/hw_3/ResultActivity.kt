package com.example.hw_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_3.databinding.ActivityResultBinding
import com.example.hw_3.model.LoveModel

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result=intent.getSerializableExtra("key")as LoveModel
        binding.resultTv.text=result.toString()
        binding.historyBtn.setOnClickListener{
            startActivity(Intent(this,HistoryActivity::class.java))
        }
    }
}