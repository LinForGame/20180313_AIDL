package com.example.why.a20180313_aidl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity###";
    private Intent intent;
    private IPet petService;
    private MyConnection myConnection = new MyConnection();
    private class MyConnection implements ServiceConnection{

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "onServiceConnected() called with: name = [" + name + "], service = [" + service + "]");
        petService = IPet.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d(TAG, "onServiceDisconnected() called with: name = [" + name + "]");
        petService = null;
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        intent = new Intent(this,MyAidlService.class);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        bindService(intent,myConnection,Service.BIND_AUTO_CREATE);
                        break;
                    case R.id.button2:
                        startService(intent);
                        break;
                    case R.id.button3:
                        stopService(intent);
                        break;
                    case R.id.button5:
                        try {
                            button5.setText("petsList:"+petService.getPets(new Person(1,"sun","sun")));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);

    }
}
