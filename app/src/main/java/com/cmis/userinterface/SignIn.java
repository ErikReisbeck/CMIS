package com.cmis.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEdit = findViewById(R.id.username);
        EditText passwordEdit = findViewById(R.id.password);

        final Button signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent overview = new Intent(SignIn.this, Overview.class);

                String name = nameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                overview.putExtra("username",name);
                overview.putExtra("password", password);

                startActivity(overview);

            }
        }
        );

        final Button signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signUpPg = new Intent(SignIn.this, SignUp.class);
                startActivity(signUpPg);
            }
        });

        }

    }

