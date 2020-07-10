package ru.skillbranch.gameofthrones.utils

import io.reactivex.Single
import retrofit2.http.GET
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface Api {
    @GET("/houses")
    fun getHouses(): Single<List<HouseRes>>
}