package com.shady.tiger.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shady.tiger.data.Apifactory
import com.shady.tiger.data.AppDB
import com.shady.tiger.data.JobsMockData
import com.shady.tiger.repo.MainRepo
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(context: Application): AndroidViewModel(context) {
    private val repo: MainRepo

    fun getJobs(): MutableLiveData<ArrayList<JobsMockData>> {
        val jobs = MutableLiveData<ArrayList<JobsMockData>>()
        viewModelScope.launch {
            try {
                jobs.postValue(repo.getJobs())
            } catch (e: Exception) {
                Log.e("Get Job:", "Error")
            }
        }
        return jobs
    }

    init {
        val jobsDao = AppDB.getDatabase(context).jobDao()
        repo = MainRepo(context, Apifactory.retrofitApi, jobsDao)
    }
}