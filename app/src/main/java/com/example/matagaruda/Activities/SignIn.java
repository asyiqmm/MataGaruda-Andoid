package com.example.matagaruda.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.RetrofitClient;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.Models.LoginResponse;
import com.example.matagaruda.R;
import com.example.matagaruda.storage.SharedPrefManager;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    EditText loginUsername, loginPassword;
    Button btn_login;
    TextView logintoregist;
    Context mContext;
    Api mApiService;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mContext = this;
        //meng-init yang ada di package apihelper
        mApiService = UtilsApi.getAPIService();
        initComponents();

    }

    public void initComponents() {
        loginUsername = (EditText) findViewById(R.id.loginUsername);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        btn_login = (Button) findViewById(R.id.btn_login);
        logintoregist = (TextView) findViewById(R.id.logintoregister);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Please Wait...", true, false);
                requestLogin();
            }
        });
        logintoregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, SignUp.class));
            }
        });
    }

    public void requestLogin() {
        mApiService.userLogin(loginUsername.getText().toString(), loginPassword.getText().toString())
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULT = new JSONObject(response.body().toString());
                                if (jsonRESULT.getString("error").equals("false")){
                                    Toast.makeText(mContext,"Berhasil login",Toast.LENGTH_SHORT).show();

                                }
                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
    }

    private void userLogin() {
        String username = loginUsername.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        if (username.isEmpty()) {
            loginUsername.setError("Username is required");
            loginUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            loginPassword.setError("Password required");
            loginPassword.requestFocus();
            return;
        }
        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().userLogin(username, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(retrofit2.Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (!loginResponse.isError()) {

                    SharedPrefManager.getInstance(SignIn.this)
                            .saveUser(loginResponse.getUser());

                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                } else {
                    Toast.makeText(SignIn.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private void userRegister(View view) {
        Intent intent = new Intent(SignIn.this, SignUp.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                userLogin();
                break;
            case R.id.logintoregister:
                userRegister(v);
                break;
        }
    }
}
