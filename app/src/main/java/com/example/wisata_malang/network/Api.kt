package com.example.wisata_malang.network

import com.example.wisata_malang.model.Vacation
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("Gallery_Malang_Batu.json")
    fun getVacation(): Call<ArrayList<Vacation>>
}