package com.example.matagaruda.Fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.matagaruda.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class EventsStatisticFragment extends Fragment {

    LineChart mpLinechart;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ArrayList<Entry> listFactors(){
        ArrayList<Entry> listFactors = new ArrayList<Entry>();
        listFactors.add(new Entry(0,20));
        listFactors.add(new Entry(1,24));
        listFactors.add(new Entry(2,2));
        listFactors.add(new Entry(3,10));
        return listFactors;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_events_statistic,container,false);
        LineDataSet lineDataSet1 = new LineDataSet(listFactors(),"Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(lineDataSet1);
        LineData data = new LineData(dataSets);
        mpLinechart = (LineChart) view.findViewById(R.id.linechart);
        mpLinechart.setData(data);
        mpLinechart.invalidate();
        return view;
    }
    public static EventsStatisticFragment newInstance(){
        EventsStatisticFragment fragment = new EventsStatisticFragment();
        return fragment;
    }
    public EventsStatisticFragment(){
        //
    }
}