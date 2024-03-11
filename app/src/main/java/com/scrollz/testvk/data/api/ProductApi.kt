package com.scrollz.testvk.data.api

import com.scrollz.testvk.BuildConfig
import com.scrollz.testvk.data.model.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("/product/search")
    suspend fun getProducts(
        @Query("q") query: String = "",
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = BuildConfig.PAGE_SIZE
    ): ResponseDTO

}
