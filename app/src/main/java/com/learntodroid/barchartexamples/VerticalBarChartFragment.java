package com.learntodroid.barchartexamples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VerticalBarChartFragment extends Fragment {
    private static final int MAX_X_VALUE = 30;
    private static final int MAX_Y_VALUE = 50;
    private static final int MIN_Y_VALUE = 5;
    private static final String SET_LABEL = "Things Set";
    BarChart chart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verticalbarchart, container, false);

        chart = view.findViewById(R.id.fragment_verticalbarchart_chart);

        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < MAX_X_VALUE; i++) {
            float x = i;
            float y = Math.max(MIN_Y_VALUE, (float) Math.random() * (MAX_Y_VALUE + 1));
            values.add(new BarEntry(x, y));
        }
        BarDataSet set1 = new BarDataSet(values, SET_LABEL);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        Description d = new Description();
        d.setText("Vertical Bar Chart");
        chart.setDescription(d);

        chart.setData(data);

        return view;
    }
}
