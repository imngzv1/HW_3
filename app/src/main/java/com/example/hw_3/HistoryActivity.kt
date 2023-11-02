package com.example.hw_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_3.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list=App.appDatabase.getLoveDao().getAll()
        list.forEach{
            binding.historyTv.append(
                "\n ${it.firstname}\n " +
                        "${it.secondName}\n" +
                        " ${it.percentage}\n" +
                        "${it.result}\n")
        }
    }
}