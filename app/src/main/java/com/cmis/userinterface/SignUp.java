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

        final Button signUp = findViewById(R.id.signUp2);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent overview = new Intent(SignUp.this, Overview.class);

                String name = nameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                String email = emailEdit.getText().toString();
                overview.putExtra("username",name);
                overview.putExtra("password", password);
                overview.putExtra("email", email);

                startActivity(overview);

            }
        }
        );

    }
}