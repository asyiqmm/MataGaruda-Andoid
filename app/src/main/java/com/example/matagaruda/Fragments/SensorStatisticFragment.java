package com.example.matagaruda.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.matagaruda.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class SensorStatisticFragment extends Fragment {

    LineChart mpLinechart;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ArrayList<Entry> listSensor1(){
        ArrayList<Entry> listSensor1 = new ArrayList<Entry>();
        listSensor1.add(new Entry(0,20));
        listSensor1.add(new Entry(1,24));
        listSensor1.add(new Entry(2,2));
        listSensor1.add(new Entry(3,10));
        return listSensor1;
    }
    private ArrayList<Entry> listSensor2(){
        ArrayList<Entry> listSensor2 = new ArrayList<Entry>();
        listSensor2.add(new Entry(0,30));
        listSensor2.add(new Entry(1,10));
        listSensor2.add(new Entry(2,5));
        listSensor2.add(new Entry(3,50));
        return listSensor2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_sensor_statistic,container,false);
        LineDataSet lineDataSet1 = new LineDataSet(listSensor1(),"Data Set 1");
        LineDataSet lineDataSet2 = new LineDataSet(listSensor2(),"Data Set 2");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        lineDataSet1.setColors(ColorTemplate.VORDIPLOM_COLORS);
        lineDataSet2.setColors(ColorTemplate.VORDIPLOM_COLORS);
        LineData data = new LineData(dataSets);
        mpLinechart = (LineChart) view.findViewById(R.id.linechartsensor);
        mpLinechart.setData(data);
        mpLinechart.invalidate();
        return view;
    }
    public static EventsStatisticFragment newInstance(){
        EventsStatisticFragment fragment = new EventsStatisticFragment();
        return fragment;
    }
    public SensorStatisticFragment(){
        //
    }
}