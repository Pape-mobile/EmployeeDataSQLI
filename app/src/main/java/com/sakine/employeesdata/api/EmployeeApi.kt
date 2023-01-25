package com.sakine.employeesdata.api

import com.sakine.employeesdata.models.Employee
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EmployeeApi {

    @GET("users")
    suspend fun getAllEmployees(
        @Query("page")
        page: Int
    ): Response<Employee>

}