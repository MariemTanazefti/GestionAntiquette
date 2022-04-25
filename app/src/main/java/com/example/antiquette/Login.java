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

public class Login extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    TextView txtCreateAccount,btnVald;
    ApiHandler apiHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail=(EditText)findViewById(R.id.email_signin);
        edtPassword=(EditText)findViewById(R.id.password_signin);
        txtCreateAccount=(TextView)findViewById(R.id.btn_register);
        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Inscription.class);
                startActivity(intent);
            }
        });
        btnVald=(TextView)findViewById(R.id.btSignIn);
        apiHandler= ApiClient.getApiClient().create(ApiHandler.class);
        btnVald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();


            }

            private void loginUser() {
                String email=edtEmail.getText().toString().trim();
                String password=edtPassword.getText().toString().trim();
                Call<User> LoginUser=apiHandler.LoginUser(email,password);
                LoginUser.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Response<User> response, Retrofit retrofit) {
                        if(response.body()!=null)
                        {
                            Intent intent2=new Intent(getApplicationContext(), Home.class);
                            startActivity(intent2);}
                        else
                        {
                            Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"failed"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                    }
                });




            }
        });

    }
}