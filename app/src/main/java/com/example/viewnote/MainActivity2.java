package com.example.viewnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.viewnote.ui.main.MainViewModel;
import com.example.viewnote.view.MyView3;

public class MainActivity2 extends AppCompatActivity {
    MyView3 myView3;
    int num=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myView3=findViewById(R.id.MyView3);

    }
    public void Add(View v){
        num++;
        myView3.setPolygonNum(num);

    }
    public void decrease(View v){
        num--;
        myView3.setPolygonNum(num);
    }
}