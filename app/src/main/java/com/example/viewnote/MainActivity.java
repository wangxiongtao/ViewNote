package com.example.viewnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
//        startActivityForResult(new Intent(
//                Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 60);

    }
}