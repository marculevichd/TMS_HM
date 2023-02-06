package com.example.homework21_tms.data.database.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.homework21_tms.data.AuthRepositoryImpl
import com.example.homework21_tms.domain.model.WorkManagerModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random


@HiltWorker
class PeriodWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted parameters: WorkerParameters,
    val authRepositoryImpl: AuthRepositoryImpl
    ): CoroutineWorker(context, parameters){


    override suspend fun doWork(): Result {

        try {
            CoroutineScope(Dispatchers.IO).launch {
                Log.w("do work called", "string from database")
                authRepositoryImpl.saveStringWorkManager(WorkManagerModel(Random.nextInt(), "just string work manager"))
            }


        } catch (e: Exception){
            Log.w("Exception", e.toString())
            Result.retry()
        }
        return Result.success()
    }

    companion object {

        const val WORKER_NAME = "Worker Name"
    }


}