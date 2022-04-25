package com.example.antiquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Inscription extends AppCompatActivity {
    EditText edtName,edtEmail,edtPass,edtCPass;
    ApiHandler apiHandler;
    TextView txtAccount;
    TextView btnSinup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        edtName=(EditText)findViewById(R.id.nameinput);
        edtEmail=(EditText)findViewById(R.id.emailinput);
        edtPass=(EditText)findViewById(R.id.passwordinput);
        edtCPass=(EditText)findViewById(R.id.Cpasswordinput);
        txtAccount=(TextView) findViewById(R.id.signIn);
        txtAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });
        btnSinup=(TextView)findViewById(R.id.btSignUp);
        apiHandler= ApiClient.getApiClient().create(ApiHandler.class);

        btnSinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();


            }

            private void addUser() {
                String name=edtName.getText().toString().trim();
                String email=edtEmail.getText().toString().trim();
                String password=edtPass.getText().toString().trim();
                String confirmPassword=edtCPass.getText().toString().trim();
                Call<User> insertUser=apiHandler.insertUser(name,email,password,confirmPassword);
                insertUser.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Response<User> response, Retrofit retrofit) {
                        Toast.makeText(getApplicationContext(),"user added",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);



                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"failed " + t.getLocalizedMessage(),Toast.LENGTH_LONG).show();


                    }
                });

            }
        });
    }
}