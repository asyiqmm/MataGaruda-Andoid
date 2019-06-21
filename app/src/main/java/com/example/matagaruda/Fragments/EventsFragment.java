package com.example.matagaruda.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ListView;
import android.widget.SearchView;
import com.example.matagaruda.Adapter.EventsAdapter;
import com.example.matagaruda.Model.Events;
import com.example.matagaruda.R;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {
    private View paramView;
    SearchView searchView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.fragment_events,container,false);
        searchView = (SearchView) paramView.findViewById(R.id.simpleSearchView);
        searchView.setQueryHint("Search IP Source");
        ListView listView = (ListView) paramView.findViewById(R.id.listViewEvents);
        List<Events> listEvents = new ArrayList<Events>();
        Events events = new Events(1,"12:00","A1221",
                "Error at the same place","1.2.3.4","1.2.4.3","A212","123",443,1234);
        listEvents.add(events);
        events = new Events(2,"11:20","A1221",
                "Error at the same place","1.2.3.4","1.2.4.3","A212","123",443,1234);
        listEvents.add(events);
        listView.setAdapter(new EventsAdapter(getActivity(), R.layout.list_events_item,listEvents));

        return paramView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
