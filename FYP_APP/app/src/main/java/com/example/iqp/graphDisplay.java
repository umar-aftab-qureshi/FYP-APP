package com.example.iqp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphDisplay extends AppCompatActivity {
    LineGraphSeries<DataPoint> series;
    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_display);
        double x,y;
        graph = (GraphView) findViewById(R.id.graphView);


        series = new LineGraphSeries<DataPoint>();



        series.appendData(new DataPoint(0,5.0),true,07);
        series.appendData(new DataPoint(0,2.5),true,07);
        series.appendData(new DataPoint(1,4),true,07);
        series.appendData(new DataPoint(2,2.9),true,07);
        series.appendData(new DataPoint(3.8,0.7),true,07);
        series.appendData(new DataPoint(4.7,5),true,07);
        series.appendData(new DataPoint(6,2),true,07);
        series.appendData(new DataPoint(6,3),true,07);



        graph.addSeries(series);




    }
}