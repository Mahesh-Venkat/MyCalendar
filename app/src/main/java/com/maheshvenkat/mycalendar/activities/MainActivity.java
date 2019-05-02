package com.maheshvenkat.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.maheshvenkat.myapplication.MyApplication;
import com.maheshvenkat.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.Companion.getGsContext().get();

        Log.e("Service URL", MyApplication.Companion.getServiceURl());
        Log.e("Test Url", MyApplication.Companion.getTestURL());
        Log.e("Mob Username", MyApplication.Companion.getMobileUserName());
        Log.e("MOB Pass", MyApplication.Companion.getMobilePassword());
        Log.e("OS Version", MyApplication.Companion.getOsVersion());
    }
}
