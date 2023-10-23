package com.example.hw_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hw_3.databinding.ActivityMainBinding
import com.example.hw_3.model.LoveModel
import com.example.hw_3.model.RetrofitService
import com.example.hw_3.view.MainView
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity(), MainView {
    val presenter=MainPresenter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView((this))
    }

    private fun initClickers() {
        with(binding){
            calculateBtn.setOnClickListener(){

                presenter.getData(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }

    override fun changeScreen(loveModel: LoveModel) {
        val intent= Intent(this,ResultActivity::class.java)
        intent.putExtra("key",loveModel)
        startActivity(intent)
    }
}