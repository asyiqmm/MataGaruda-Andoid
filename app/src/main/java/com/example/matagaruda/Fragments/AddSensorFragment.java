package com.example.matagaruda.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.Base64Encoder;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.Models.SensorRaw;
import com.example.matagaruda.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSensorFragment extends Fragment {
    EditText mDeviceName, mHostname, mIPAddress, mLocation, mProtectedSub;
    View paramView;
    Api mApiService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.fragment_addsensor, container, false);
        getActivity().setTitle("Create Sensor");
        mApiService = UtilsApi.getAPIService();
        mDeviceName = (EditText) paramView.findViewById(R.id.addDeviceName);
        mHostname = (EditText) paramView.findViewById(R.id.addHostname);
        mIPAddress = (EditText) paramView.findViewById(R.id.addIPAddress);
        mLocation = (EditText) paramView.findViewById(R.id.addLocation);
        mProtectedSub = (EditText) paramView.findViewById(R.id.addProtected);
        Button btnCreate = (Button) paramView.findViewById(R.id.addSensor);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
                createS();
            }
        });
        return paramView;
    }

    private void check() {
        String device = mDeviceName.getText().toString().trim();
        String host = mHostname.getText().toString().trim();
        String ip = mIPAddress.getText().toString().trim();
        String loc = mLocation.getText().toString().trim();
        String protect = mProtectedSub.getText().toString().trim();

        if (device.isEmpty()) {
            mDeviceName.setError("This field is required");
            mDeviceName.requestFocus();
            return;
        }
        if (host.isEmpty()) {
            mHostname.setError("This field is required");
            mHostname.requestFocus();
            return;
        }
        if (ip.isEmpty()) {
            mIPAddress.setError("This field is required");
            mIPAddress.requestFocus();
            return;
        }
        if (loc.isEmpty()) {
            mLocation.setError("This field is required");
            mLocation.requestFocus();
            return;
        }
        if (protect.isEmpty()) {
            mProtectedSub.setError("This field is required");
            mProtectedSub.requestFocus();
            return;
        }
    }
    private void createS() {
        SensorRaw sensorRaw = new SensorRaw(
                mDeviceName.getText().toString(),
                mHostname.getText().toString(),
                mIPAddress.getText().toString(),
                mLocation.getText().toString(),
                mProtectedSub.getText().toString()
        );
        String encoding = Base64Encoder.encode(UtilsApi.username + ":" + UtilsApi.password);
        mApiService.createSensor("Basic "+encoding,sensorRaw).enqueue(new Callback<SensorRaw>() {
            @Override

            public void onResponse(Call<SensorRaw> call, Response<SensorRaw> response) {
                if (response.code() == 200) {
                    Toast.makeText(getContext(), "Sensor created", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<SensorRaw> call, Throwable t) {
                Toast.makeText(getContext(), "Sensor failed to created", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onBackPressed() {

    }


}
