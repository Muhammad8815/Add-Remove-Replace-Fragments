package com.example.replacefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addone,removeone,replaceone,addtwo,removetwo,replacetwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addone=findViewById(R.id.addone);
        addtwo=findViewById(R.id.addtwo);
        removeone=findViewById(R.id.removeone);
        replaceone=findViewById(R.id.replaceone);
        removetwo=findViewById(R.id.removetwo);
        replacetwo=findViewById(R.id.replacetwo);
        FragmentManager manager = getFragmentManager();
        addone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentone fragmentone=new fragmentone();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.fl,fragmentone,"addone");
                transaction.commit();
            }
        });
        removeone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentone fragmentone=(com.example.replacefragment.fragmentone) manager.findFragmentByTag("addone");
                FragmentTransaction transaction=manager.beginTransaction();
                if(fragmentone!=null)
                {
                    transaction.remove(fragmentone);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"One is empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        replaceone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentone fragmentone=new fragmentone();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fl,fragmentone,"addone");
                transaction.commit();
            }
        });
        addtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmenttwo fragmenttwo=new fragmenttwo();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.fl,fragmenttwo,"addtwo");
                transaction.commit();
            }
        });
        removetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmenttwo fragmenttwo=(com.example.replacefragment.fragmenttwo) manager.findFragmentByTag("addtwo");
                FragmentTransaction transaction=manager.beginTransaction();
                if(fragmenttwo!=null)
                {
                    transaction.remove(fragmenttwo);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"two is empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        replacetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmenttwo fragmenttwo=new fragmenttwo();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fl,fragmenttwo,"addtwo");
                transaction.commit();
            }
        });

    }
}