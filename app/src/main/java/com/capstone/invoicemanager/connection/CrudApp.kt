package com.capstone.invoicemanager.connection

import com.capstone.invoicemanager.datas.Invoice
import com.capstone.invoicemanager.datas.User
import com.capstone.invoicemanager.datas.UserResponse

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface CrudApp {
    @GET("/user")
    suspend fun getUser(
        @Query("userName") username: String,
        @Query("password") password: String
    ):Response<Int>

    @POST("/user")
    suspend fun createUser(@Body user: User):Response<Int>

    @GET("/invoice/{id}")
    suspend fun getInvoice(@Path("id") id: Int):Response<List<Invoice>>

    @GET("/singleinvoice/{id}")
    suspend fun getSingleInvoice(@Path("id") id: Int):Response<Invoice>

    @DELETE("/invoice/{id}")
    suspend fun deleteInvoice(@Path("id") id: Int):Response<Int>

    @POST("/invoice")
    suspend fun createInvoice(@Body invoice : Invoice):Response<Void>

    @PUT("/invoice/{id}")
    suspend fun editInvoice(@Path("id") id: Int ,@Body invoice: Invoice): Response<Void>


}