package com.example.hw_3

import android.util.Log
import com.example.hw_3.model.LoveModel
import com.example.hw_3.model.RetrofitService
import com.example.hw_3.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter {
    val api = RetrofitService().api
    val TAG = "ololo"

    lateinit var view: MainView

    fun getData(firstName: String, secondName: String) {
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val model = response.body()
                    model?.let {
                        view.changeScreen(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}") // Удалена лишняя запятая здесь
            }
        })
    }

    fun attachView(view: MainView) {
        this.view=view
    }
}
