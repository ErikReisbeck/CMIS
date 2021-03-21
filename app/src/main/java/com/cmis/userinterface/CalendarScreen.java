package com.cmis.userinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarScreen extends AppCompatActivity {

    CalendarView mCalendarView;
    ArrayList<String> categoriesList = new ArrayList<String>();
    ArrayList<Integer> amountList = new ArrayList<Integer>();
    ArrayList<String> dateList = new ArrayList<String>();
    TextView spentText;
    TextView spentName;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        spentText = findViewById(R.id.spentText);
        spentName = findViewById(R.id.spentName);

        Intent intent = getIntent();

        categoriesList = intent.getStringArrayListExtra("categoriesList");
        amountList = intent.getIntegerArrayListExtra("amountList");
        dateList = intent.getStringArrayListExtra("dateList");
        username = intent.getStringExtra("username");

            mCalendarView = findViewById(R.id.calendarView);
            mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                    String date = (i1+1) + "/" + i2 + "/" + i;

                    spentText.setText("Money Earned: $0");
                    spentName.setText("Income Name: ");

                    for(int k = 0; k < dateList.size(); k++)
                    {
                        if(dateList.get(k).equals(date))
                        {

                            int amt = amountList.get(k);
                            String category = categoriesList.get(k);

                            spentText.setText("Money Earned: $" + amt);
                            spentName.setText("Income Name: " + category);
                        }

                    }

                }
            });


        final Button overview = findViewById(R.id.button19);
        overview.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent overview = new Intent(CalendarScreen.this, Overview.class);
                                            overview.putExtra("username", username);
                                            startActivity(overview);
                                        }
                                    }
        );
        final Button logging = findViewById(R.id.button20);
        logging.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           Intent InputScreen = new Intent(CalendarScreen.this, InputScreen.class);
                                           InputScreen.putExtra("username", username);

                                           startActivity(InputScreen);
                                       }
                                   }
        );
        final Button calendar = findViewById(R.id.button21);
        calendar.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent Calendar = new Intent(CalendarScreen.this, CalendarScreen.class);
                                            Calendar.putExtra("username", username);

                                            startActivity(Calendar);
                                        }
                                    }
        );
    }
}