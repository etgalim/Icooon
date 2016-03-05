package com.etgalim.ikon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
    }

}


