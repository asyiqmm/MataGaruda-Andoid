package com.example.matagaruda.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.Base64Encoder;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.R;
import com.example.matagaruda.storage.Preferences;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;


public class SignIn extends AppCompatActivity {
    private static final String TAG = "SignIn";
    EditText loginPassword, loginUsername;
    Button mLogin;
    Context mContext;
    TextView mToRegist;
    Api mApiService;
    ProgressDialog loading;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); //Inisialisasi isi package ApiHelper
        preferences = new Preferences(this);
        initComponents();
    }

    private void initComponents() {
        loginUsername = (EditText) findViewById(R.id.loginUsername);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        mLogin = (Button) findViewById(R.id.btn_register);
        mToRegist = (TextView) findViewById(R.id.logintoregister);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Please wait...", true, false);
                requestLogin();
            }
        });

        //mengarahkan ke SignUp Activity
        mToRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SignUp.class));
            }
        });
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        finish();
    }

    private void requestLogin() {
        String encoding = Base64Encoder.encode(loginUsername.getText().toString() + ":" + loginPassword.getText().toString());
        Log.d(TAG, "Basic: " + encoding);
        //mendapatkan inputan dari form username dan password
        mApiService.loginUser(loginUsername.getText().toString(), loginPassword.getText().toString(), "Basic " + encoding) //basic Auth
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        loginUse();
                        if (response.isSuccessful()) {
                            loading.dismiss();
                            try {
                                //mendapatkan token
                                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                Log.d(TAG, "ini token: "+jsonRESULTS.getString("token"));
                                UtilsApi.username = loginUsername.getText().toString();
                                UtilsApi.password = loginPassword.getText().toString();
                                UtilsApi.TOKEN = jsonRESULTS.getString("token");
                                Log.d(TAG, "username log"+UtilsApi.username);
//                                Log.d(TAG, "saya panggil token: "+UtilsApi.TOKEN); //memanggil token dari utilsApi
                                startActivity(new Intent(mContext, MainActivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                finish();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }
    private void loginUse() {
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
        return;
    }
}
