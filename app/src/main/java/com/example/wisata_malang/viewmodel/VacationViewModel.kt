package com.example.wisata_malang.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wisata_malang.model.Vacation
import com.example.wisata_malang.network.Configuration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VacationViewModel : ViewModel(){
    val data = MutableLiveData<ArrayList<Vacation>>()

    internal fun getData(){
        Configuration().api().getVacation().enqueue(object : Callback<ArrayList<Vacation>>{
            override fun onFailure(call: Call<ArrayList<Vacation>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<ArrayList<Vacation>>,
                response: Response<ArrayList<Vacation>>
            ) {
                data.value = response.body()
            }
        })
    }

    internal fun setData() : MutableLiveData<ArrayList<Vacation>>{
        return data
    }
}