package com.cmis.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class Overview extends AppCompatActivity {
    AnyChartView anyChartView;
    String[] months = {"Jan", "Feb", "Mar"};
    int[] spending = {500, 800, 2000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        final Button overview = findViewById(R.id.overviewBtn);
        overview.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          Intent overview = new Intent(Overview.this, Overview.class);

                                          startActivity(overview);
                                      }
                                  }
        );
        final Button logging = findViewById(R.id.loggingBtn);
        logging.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          Intent InputScreen = new Intent(Overview.this, InputScreen.class);

                                          startActivity(InputScreen);
                                      }
                                  }
        );
        final Button calendar = findViewById(R.id.calendarBtn);
        calendar.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          Intent Calendar = new Intent(Overview.this, CalendarScreen.class);

                                          startActivity(Calendar);
                                      }
                                  }
        );

        anyChartView = findViewById(R.id.pieChart);
        setupPieChart();

    }
    public void setupPieChart(){

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < months.length; i++){
            dataEntries.add(new ValueDataEntry(months[i], spending[i]));
        }
        pie.data(dataEntries);
        pie.title("Your Budget at a glance");
        anyChartView.setChart(pie);

    }
}