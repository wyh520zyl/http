package com.wang.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.wang.myapplication.http.HiRetrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiService apiService = HiRetrofit.INSTANCE.create(ApiService.class);
    }
}