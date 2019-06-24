package com.example.matagaruda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.matagaruda.R;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.logintoregister:
                break;
            case R.id.btn_login:
                userLogin(v);
                break;
        }
    }

    private void userLogin(View view) {
        Intent intent = new Intent(SignUp.this, SignIn.class);
        startActivity(intent);
    }
}