package com.shady.tiger.repo

import android.content.Context
import android.util.Log
import com.shady.tiger.Utils
import com.shady.tiger.data.API
import com.shady.tiger.data.JobDAO
import com.shady.tiger.data.JobsMockData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList

class MainRepo(val context: Context, private val api: API, private val dao: JobDAO) {
    suspend fun getJobs(): ArrayList<JobsMockData> = withContext(Dispatchers.IO) {
        if(Utils().isNetworkConnected(context)){
            fillDB(api.getJobsAsync())
            Log.e("network", "fi internet")
        }else{
            Log.e("network", "no internet")
        }
        dao.getJobs() as ArrayList
    }

    private suspend fun fillDB(jobs: ArrayList<JobsMockData> )  {
        dao.deleteAll()
        for (job in jobs){
            dao.insert(job)
        }
    }
}