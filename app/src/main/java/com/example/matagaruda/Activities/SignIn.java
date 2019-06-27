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
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.R;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;


public class SignIn extends AppCompatActivity{
    private static final String TAG = "SignIn";
    EditText loginPassword, loginUsername;
    Button mLogin;
    Context mContext;
    TextView mRegist;
    Api mApiService;
    ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); //Inisialisasi isi package ApiHelper
        initComponents();
    }

    private void initComponents() {
        loginUsername = (EditText) findViewById(R.id.loginUsername);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        mLogin = (Button) findViewById(R.id.btn_login);
        mRegist = (TextView) findViewById(R.id.logintoregister);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Please wait...", true, false);
                requestLogin();
            }
        });

        mRegist.setOnClickListener(new View.OnClickListener() {
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
        mApiService.userLogin(loginUsername.getText().toString(), loginPassword.getText().toString(),"Basic YWRtaW46YWRtaW4=")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                Log.d(TAG, "ini token: "+jsonRESULTS.getString("token"));
                                UtilsApi.TOKEN = jsonRESULTS.getString("token");
                                Log.d(TAG, "saya panggil token: "+UtilsApi.TOKEN);
                                Intent i = new Intent(SignIn.this,MainActivity.class);
                                startActivity(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
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
}
