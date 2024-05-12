package com.capstone.invoicemanager.connection

import com.capstone.invoicemanager.datas.Invoice
import com.capstone.invoicemanager.datas.UserResponse

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.PUT
import retrofit2.http.Path


interface CrudApp {
    @GET("/user")
    suspend fun getUser(
        @Query("username") username: String,
        @Query("password") password: String
    ):Response<Int>

    @GET("/invoice/{id}")
    suspend fun getInvoice(@Path("id") id: Int):Response<List<Invoice>>

}