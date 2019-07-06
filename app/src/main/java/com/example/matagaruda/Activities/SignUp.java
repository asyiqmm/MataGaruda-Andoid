package com.example.matagaruda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.Models.User;
import com.example.matagaruda.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    TextView mToLogin;
    EditText mUsername, mPassword, mPassword2, mEmail, mCompany, mFirst_name, mLast_name;

    Button mRegist;
    Api mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mApiService = UtilsApi.getAPIService();
        mToLogin = (TextView) findViewById(R.id.logintoregister);
        mUsername = (EditText) findViewById(R.id.registerUsername);
        mPassword = (EditText) findViewById(R.id.registerPassword);
        mPassword2 = (EditText) findViewById(R.id.registerPassword2);
        mEmail = (EditText) findViewById(R.id.registerEmail);
        mCompany = (EditText) findViewById(R.id.registerCompany);
        mFirst_name = (EditText) findViewById(R.id.registerFirstName);
        mLast_name = (EditText) findViewById(R.id.registerLastName);

        mRegist = (Button) findViewById(R.id.btn_register);
        mRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
                register();
            }
        });

        mToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, SignIn.class);
                startActivity(i);
            }
        });
    }

    private void check() {
        String username = mUsername.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String password2 = mPassword2.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String first = mFirst_name.getText().toString().trim();
        String last = mLast_name.getText().toString().trim();
        String company = mCompany.getText().toString().trim();


        if (username.isEmpty()) {
            mUsername.setError("Username is required");
            mUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            mPassword.setError("Password is required");
            mPassword.requestFocus();
            return;
        }
        if (password2.isEmpty()) {
            mPassword2.setError("Password is required");
            mPassword2.requestFocus();
            return;
        }
        if (!password.equals(password2)) {
            mPassword.setError("Password Not Matching");
            mPassword2.setError("Password Not Matching");
            mPassword.requestFocus();
            mPassword2.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            mEmail.setError("Email is required");
            mEmail.requestFocus();
            return;
        }
        if (first.isEmpty()) {
            mFirst_name.setError("First Name is required");
            mFirst_name.requestFocus();
            return;
        }
        if (last.isEmpty()) {
            mLast_name.setError("Last Name is required");
            mLast_name.requestFocus();
            return;
        }
        if (company.isEmpty()) {
            mCompany.setError("Company is required");
            mCompany.requestFocus();
            return;
        }

    }

    private void register() {
        User user = new User(
                mUsername.getText().toString(),
                mPassword.getText().toString(),
                mEmail.getText().toString(),
                mFirst_name.getText().toString(),
                mLast_name.getText().toString(),
                mCompany.getText().toString()
        );
        mApiService.createUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    Toast.makeText(SignUp.this, "Registration Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUp.this, "Registration Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


}