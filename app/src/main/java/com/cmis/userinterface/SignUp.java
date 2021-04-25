package com.cmis.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText nameEdit = findViewById(R.id.username2);
        EditText passwordEdit = findViewById(R.id.password2);
        EditText emailEdit = findViewById(R.id.email);

        Database db = Database.getDatabase(this);
        UserDao userDao = db.userDao();

        final Button signUp = findViewById(R.id.signUp2);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent inputScreen = new Intent(SignUp.this, InputScreen.class);

                User newUser = new User(emailEdit.getText().toString(), nameEdit.getText().toString(),
                        passwordEdit.getText().toString());
                userDao.insertUser(newUser);


                startActivity(inputScreen);

            }
        }
        );

    }
}