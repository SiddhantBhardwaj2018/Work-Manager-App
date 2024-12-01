package com.siddhantbhardwaj.workmanagerapp;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Data data = getInputData();
        int countingLimit = data.getInt("max_limit",0);

        for(int i = 0; i < countingLimit;i++){
            Log.i("TAGY","Count is: " + i);
        }

        Data dataToSend = new Data.Builder()
                .putString("msg","Task done successfully")
                .build();

        return Result.success(dataToSend);
    }



}
