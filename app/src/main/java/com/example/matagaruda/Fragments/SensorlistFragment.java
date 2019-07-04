package com.example.matagaruda.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.matagaruda.Adapter.SensorListAdapter;
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.Base64Encoder;
import com.example.matagaruda.Api.RetrofitClient;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.Models.Sensor;
import com.example.matagaruda.Models.SensorModel;
import com.example.matagaruda.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class SensorlistFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Sensor> sensors;
    private View view;
    RetrofitClient retrofitClient;
    SensorListAdapter sensorListAdapter;
    Api api;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sensorlist, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.listViewSensor);
        listsensor();
        return view;
    }

    private void listsensor() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        api = retrofitClient.getClient("http://10.8.0.2:5000/").create(Api.class);
        String encoding = Base64Encoder.encode(UtilsApi.username + ":" + UtilsApi.password);
        api.listSensor(UtilsApi.username, UtilsApi.password, "Basic " + encoding)
                .enqueue(new Callback<SensorModel>() {
                    @Override
                    public void onResponse(Call<SensorModel> call, Response<SensorModel> response) {
                        if (response.code()==200){
                            sensors = response.body().getSensors();
                            sensorListAdapter = new SensorListAdapter(getContext(),sensors);
                            recyclerView.setAdapter(sensorListAdapter);
                            Toast.makeText(getContext(),"Successs",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(),"Gagal",Toast.LENGTH_SHORT).show();
                        }
//                        if (response.isSuccessful()) {
//                            try {
//                                Log.d(TAG, "ini komponen: " + (List<SensorModel>) response.body());
//                                sensors = (List<Sensor>) response.body();
//                                JSONObject jsonRESULTS = new JSONObject(response.body().toString());
//                                Log.d(TAG, "device_id: " + jsonRESULTS.getString("admin"));
////                        JSONObject jsonRESULTS = new JSONObject((Map) response.body());
////                        Log.d(TAG, "INI : " + jsonRESULTS.getString("company"));
//                                listView.setAdapter(new SensorListAdapter(getActivity().getApplicationContext(), sensors));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }else {
//
//                        }
                    }

                    @Override
                    public void onFailure(Call<SensorModel> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}