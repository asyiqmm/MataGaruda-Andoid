package com.example.matagaruda.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.matagaruda.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class TopSignatureFragment extends Fragment {
    int[] colorClassArray = new int[]{Color.parseColor("#e2c275"),Color.parseColor("#305f72"),
            Color.parseColor("#f17e7e")};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View paramView = inflater.inflate(R.layout.fragment_top_signature, container, false);
        PieChart pieChart = (PieChart) paramView.findViewById(R.id.piechart);

        PieDataSet pieDataSet1 = new PieDataSet(pieEntries(),"ehhe");
        pieDataSet1.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet1.setValueTextSize(12);
        pieDataSet1.setValueTextColor(Color.parseColor("#ffffff"));
        PieData pieData1 = new PieData(pieDataSet1);
        pieChart.setCenterTextRadiusPercent(50);
        pieChart.getDescription().setEnabled(false);
        pieChart.getLegend().setTextSize(13);
        pieChart.setData(pieData1);
        pieChart.invalidate();
        return paramView;
    }

    private ArrayList<PieEntry> pieEntries(){
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(150,"Dionaea"));
        pieEntries.add(new PieEntry(100,"Cowrie"));
        pieEntries.add(new PieEntry(200,"asGlastopf"));
        pieEntries.add(new PieEntry(150,"adDionaea"));
        pieEntries.add(new PieEntry(100,"asxCowrie"));
        pieEntries.add(new PieEntry(200,"xzGlastopf"));
        pieEntries.add(new PieEntry(150,"wdDionaea"));
        pieEntries.add(new PieEntry(100,"wdCowrie"));
        pieEntries.add(new PieEntry(200,"qwGlastopf"));
        pieEntries.add(new PieEntry(150,"rDionaea"));
        pieEntries.add(new PieEntry(100,"eeCowrie"));
        pieEntries.add(new PieEntry(200,"ttGlastopf"));
        return pieEntries;
    }
}
