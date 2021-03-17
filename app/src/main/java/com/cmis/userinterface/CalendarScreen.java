package com.cmis.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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