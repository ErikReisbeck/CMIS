package com.cmis.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputScreen extends AppCompatActivity {
    EditText textBox;
    Button passButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //textBox = (EditText) findViewById(R.id.textBox);
        //passButton = (Button) findViewById(R.id.passButton);

        /**passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textBox.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("message", str);

                startActivity(intent);
            }
        });**/
        final Button overview = findViewById(R.id.button15);
        overview.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent overview = new Intent(InputScreen.this, Overview.class);

                                            startActivity(overview);
                                        }
                                    }
        );
        final Button logging = findViewById(R.id.button16);
        logging.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           Intent InputScreen = new Intent(InputScreen.this, InputScreen.class);

                                           startActivity(InputScreen);
                                       }
                                   }
        );
        final Button calendar = findViewById(R.id.button17);
        calendar.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent Calendar = new Intent(InputScreen.this, CalendarScreen.class);

                                            startActivity(Calendar);
                                        }
                                    }
        );
    }
}