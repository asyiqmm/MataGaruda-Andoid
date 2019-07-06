package com.example.matagaruda.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.matagaruda.Adapter.EventsAdapter;
import com.example.matagaruda.Api.Api;
import com.example.matagaruda.Api.Base64Encoder;
import com.example.matagaruda.Api.UtilsApi;
import com.example.matagaruda.Models.Events;
import com.example.matagaruda.Models.EventsModel;
import com.example.matagaruda.Models.EventsRaw;
import com.example.matagaruda.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class EventsFragment extends Fragment {
    private View paramView;
    private SearchView searchView;
    private RecyclerView recyclerView;
    EventsAdapter eventsAdapter;
    private List<Events> events;
    Api api;
    Button btnRefresh;
    EditText limit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.fragment_events,container,false);
        searchView = (SearchView) paramView.findViewById(R.id.simpleSearchView);
        searchView.setQueryHint("Search IP Source");
        api = UtilsApi.getAPIService();
        btnRefresh = (Button) paramView.findViewById(R.id.refreshevents);
        recyclerView = (RecyclerView) paramView.findViewById(R.id.listViewEvents);
        limit = (EditText) paramView.findViewById(R.id.limitevents);
        listEventsFirst();

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();

            }
        });

        return paramView;
    }
    private void check() {
        String limi = limit.getText().toString().trim();
        if (limi.isEmpty()) {
            limit.setError("Limit is required");
            return;
        }else{
            listEvents();
        }
    }
        private void listEventsFirst() {
        EventsRaw raw = new EventsRaw();
        raw.setCompany("admin");
        raw.setLimit(10);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String encoding = Base64Encoder.encode(UtilsApi.username + ":" + UtilsApi.password);
        api.listEvents( "Basic "+encoding,raw)
                .enqueue(new Callback<EventsModel>() {
                    @Override
                    public void onResponse(Call<EventsModel> call, Response<EventsModel> response) {
                        if (response.code()==200){
                            events = response.body().getData();
//                            Log.d(TAG, "INI EVENTS: "+events.get(0).getProtocol());
                            eventsAdapter = new EventsAdapter(getContext(),events);
                            recyclerView.setAdapter(eventsAdapter);
//                            Log.d(TAG, "onResponse: ");
                            Toast.makeText(getContext(),"Event Successs",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(),"Gagal",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EventsModel> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void listEvents() {
        EventsRaw raw = new EventsRaw();
        raw.setCompany("admin");
        String lim = limit.getText().toString();
        int finallim = Integer.parseInt(lim);
        raw.setLimit(finallim);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String encoding = Base64Encoder.encode(UtilsApi.username + ":" + UtilsApi.password);
        api.listEvents( "Basic "+encoding,raw)
                .enqueue(new Callback<EventsModel>() {
                    @Override
                    public void onResponse(Call<EventsModel> call, Response<EventsModel> response) {
                        if (response.code()==200){
                            events = response.body().getData();
//                            Log.d(TAG, "INI EVENTS: "+events.get(0).getProtocol());
                            eventsAdapter = new EventsAdapter(getContext(),events);
                            recyclerView.setAdapter(eventsAdapter);
//                            Log.d(TAG, "onResponse: ");
                            Toast.makeText(getContext(),"Event Successs",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(),"Gagal",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EventsModel> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
