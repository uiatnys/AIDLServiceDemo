package com.wzh.aidlservicedemo;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 99210 on 2017/7/8.
 */

public class RemoteService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    IRemoteService mBinder = new IRemoteService.Stub() {
        @Override
        public HelloMsg sayHello(String type) throws RemoteException {
            Log.e("==","IRemoteService.sayHello,service pid is"+Process.getThreadPriority(Process.myTid()));
            return new HelloMsg("msg from service", Process.getThreadPriority(Process.myTid()));
        }

        @Override
        public HelloMsg getMsg() throws RemoteException {
            return new HelloMsg("fromService",Process.getThreadPriority(Process.myTid()));
        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("==","ServiceDemo onBind,package is "+intent.getPackage());
        Toast.makeText(this,"ServiceDemo onBind,package is"+intent.getPackage(),Toast.LENGTH_LONG).show();
        return (IBinder) mBinder;
    }
}
