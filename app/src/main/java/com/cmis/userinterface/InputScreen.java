package com.cmis.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class InputScreen extends AppCompatActivity {
    EditText incomeAmount, incomeCategory, incomeDate, expensesAmount, expensesCategory, expensesDate;
    FloatingActionButton incomeButton, expensesButton;
    EntryDao entryDao;


    public void incomeOnClick(View view){
        //amountList.add(Integer.parseInt(incomeAmount.getText().toString()));
        //categoriesList.add(incomeCategory.getText().toString());
        //dateList.add(incomeDate.getText().toString());

        incomeAmount.setText("");
        incomeCategory.setText("");
        incomeDate.setText("");

    }
    public void expensesOnClick(View view){
        int amount = Integer.parseInt(expensesAmount.getText().toString());
        String category = expensesCategory.getText().toString();
        String date = expensesDate.getText().toString();

        Entry newEntry = new Entry(amount, category, date);
        entryDao.insertEntry(newEntry);

        expensesAmount.getText().clear();
        expensesCategory.getText().clear();
        expensesDate.getText().clear();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Database db = Database.getDatabase(this);
        entryDao = db.entriesDao();

        incomeAmount =  findViewById(R.id.incomeAmount);
        incomeCategory =  findViewById(R.id.incomeCategory);
        incomeDate =  findViewById(R.id.incomeDate);
        expensesAmount =  findViewById(R.id.expensesAmount);
        expensesCategory =  findViewById(R.id.expensesCategory);
        expensesDate =  findViewById(R.id.expensesDate);
        incomeButton = findViewById(R.id.incomeButton);
        expensesButton = findViewById(R.id.expensesButton);

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