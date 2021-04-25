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
import java.util.List;

public class CalendarScreen extends AppCompatActivity {

    CalendarView mCalendarView;
    TextView spentText;
    TextView spentName;
    EntryDao entryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        spentText = findViewById(R.id.spentText);
        spentName = findViewById(R.id.spentName);

        Database db = Database.getDatabase(this);
        entryDao = db.entriesDao();
        List<Entry> entryList = entryDao.getAll();

        mCalendarView = findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                    String date = (i1+1) + "/" + i2 + "/" + i;
                    System.out.println(date);

                    spentText.setText("Money Earned: $0");
                    spentName.setText("Expense Name: ");

                    for(int k = 0; k < entryList.size(); k++) {
                        if(entryList.get(k).date.equals(date)) {
                            spentText.setText("Money Earned: $" + entryList.get(k).amount);
                            spentName.setText("Expense Name: " + entryList.get(k).category);
                        }

                    }

                }
            });


        final Button overview = findViewById(R.id.button19);
        overview.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent overview = new Intent(CalendarScreen.this, Overview.class);
                                            startActivity(overview);
                                        }
                                    }
        );
        final Button logging = findViewById(R.id.button20);
        logging.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           Intent InputScreen = new Intent(CalendarScreen.this, InputScreen.class);
                                           startActivity(InputScreen);
                                       }
                                   }
        );
        final Button calendar = findViewById(R.id.button21);
        calendar.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent Calendar = new Intent(CalendarScreen.this, CalendarScreen.class);
                                            startActivity(Calendar);
                                        }
                                    }
        );
    }
}