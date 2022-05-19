package com.example.antiquette;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView txtPourcentage;
    int value;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progresbar);
        txtPourcentage = findViewById(R.id.txt_pourcentage);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                progressAnimation();

            }
        });
        thread.start();
    }
    public void progressAnimation(){
        for (value=0;value<100;value=value+1){
            try {
                Thread.sleep(50);
                progressBar.setProgress(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    txtPourcentage.setText(String.valueOf(value+" %"));

                }
            });

        }


                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }


    }


