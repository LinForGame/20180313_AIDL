package com.example.why.a20180313_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WHY on 2018/3/13.
 */

public class MyAidlService extends Service {
    private static final String TAG = "MyAidlService###";
    private PetBinder petBinder;
    private static Map<Person , List<Pet>> pets
            = new HashMap<Person , List<Pet>>();
        static {
            // 初始化pets Map集合
            ArrayList<Pet> list1 = new ArrayList<Pet>();
            list1.add(new Pet("旺财" , 4.3));
            list1.add(new Pet("来福" , 5.1));
            pets.put(new Person(1, "sun" , "sun") , list1);
            ArrayList<Pet> list2 = new ArrayList<Pet>();
            list2.add(new Pet("kitty" , 2.3));
            list2.add(new Pet("garfield" , 3.1));
            pets.put(new Person(2, "bai" , "bai") , list2);
        }
    private AidlBinder aidlBinder = new AidlBinder();

    public class AidlBinder extends IMyAidlInterface.Stub{

        @Override
        public String getString(String type, int count) throws RemoteException {
            Log.d(TAG, "getString() called with: type = [" + type + "], count = [" + count + "]");
            return null;
        }

        @Override
        public List getList() throws RemoteException {
            Log.d(TAG, "getList() called");
            return null;
        }
    }

    public class PetBinder extends IPet.Stub{
        @Override
        public List<Pet> getPets(Person owner) throws RemoteException {
            return pets.get(owner);
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() called with: intent = [" + intent + "]");
        /* 返回catBinder对象
		 * 在绑定本地Service的情况下，该catBinder对象会直接
		 * 传给客户端的ServiceConnection对象
		 * 的onServiceConnected方法的第二个参数；
		 * 在绑定远程Service的情况下，只将catBinder对象的代理
		 * 传给客户端的ServiceConnection对象
		 * 的onServiceConnected方法的第二个参数；
		 */
        return petBinder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate() called");
        petBinder = new PetBinder();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() called with: intent = [" + intent + "], flags = [" + flags + "], startId = [" + startId + "]");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind() called with: intent = [" + intent + "]");
        return super.onUnbind(intent);
    }
}
