package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto.Adapters.ProductAdapter;

public class Home extends AppCompatActivity {

    private TextView textViewName;
    private Button btnSucursales, btnProductos, btnServicios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewName = (TextView) findViewById(R.id.textViewName);
        Bundle recibeNombre = getIntent().getExtras();
        String name = recibeNombre.getString("Name");
        textViewName.setText(name);

        btnSucursales = (Button) findViewById(R.id.btnSucursales);
        btnProductos = (Button) findViewById(R.id.btnProductos);
        btnServicios = (Button) findViewById(R.id.btnServicios);

        btnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Products.class);
                startActivity(intent);
            }
        });

    }
}