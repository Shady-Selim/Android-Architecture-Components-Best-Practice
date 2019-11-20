package com.shady.tiger.data

import retrofit2.http.GET
import kotlin.collections.ArrayList

interface API {
    @GET("jobs")
    suspend fun getJobsAsync(): ArrayList<JobsMockData>
}