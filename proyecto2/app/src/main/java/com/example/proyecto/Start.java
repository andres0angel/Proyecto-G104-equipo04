package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    private Button btnStart;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart = (Button) findViewById(R.id.btnStart);
        editTextName = (EditText) findViewById(R.id.editTextName);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle enviaNombre = new Bundle();
                enviaNombre.putString("Name",editTextName.getText().toString());

                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.putExtras(enviaNombre);
                startActivity(intent);
            }
        });

    }
}