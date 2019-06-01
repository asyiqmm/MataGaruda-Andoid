package com.example.matagaruda.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.matagaruda.R;
import lecho.lib.hellocharts.model.*;
import lecho.lib.hellocharts.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {
    LineChartView lineChartView;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
    private View paramView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        paramView = inflater.inflate(R.layout.fragment_events, container, false);
        lineChartView = paramView.findViewById(R.id.chart);
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }
        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        List lines = new ArrayList();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);
        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);
        Axis yAxis = new Axis();
        yAxis.setName("Sales in millions");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);
        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
        return paramView;
    }

}
