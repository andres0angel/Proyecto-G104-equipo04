package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.example.proyecto.Adapters.ProductAdapter;
import com.example.proyecto.DB.DBFirebase;
import com.example.proyecto.Entities.Product;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProducts = new ArrayList<>();
        dbFirebase = new DBFirebase();


        /*
        //CREACION DE PRODUCTOS
        Product productClarinete = new Product("Clarinete soprano","Marca Yamaha 45, hecho en madera.","","",1500000,R.drawable.clarinete);
        Product productCorno = new Product("Corno francés","Marca Yamaha, hecho en bronce.","","",2500000,R.drawable.corno);
        Product productFagot = new Product("Fagot","Marca Yamaha serie 4A, hecho en madera.","","",8700000,R.drawable.fagot);
        Product productFlauta = new Product("Flauta traversa","Marca Júpiter, hecha en bronce.","","",900000,R.drawable.flauta);
        Product productSaxofon = new Product("Saxofon tenor","Marca Jimbao, hecho en bronce.","","",1700000,R.drawable.saxofon);
        Product productTrombon = new Product("Trombón","Marca Yamaha serie 100, hecho en bronce.","", "",1100000,R.drawable.trombon);
        Product productTuba = new Product("Tuba","Marca Aristocrat 15, hecho en bronce.","", "", 9000000,R.drawable.tuba);



        dbFirebase.insertData(productClarinete);
        dbFirebase.insertData(productCorno);
        dbFirebase.insertData(productFagot);
        dbFirebase.insertData(productFlauta);
        dbFirebase.insertData(productSaxofon);
        dbFirebase.insertData(productTrombon);
        dbFirebase.insertData(productTuba);



        arrayProducts.add(productClarinete);
        arrayProducts.add(productCorno);
        arrayProducts.add(productFagot);
        arrayProducts.add(productFlauta);
        arrayProducts.add(productSaxofon);
        arrayProducts.add(productTrombon);
        arrayProducts.add(productTuba);



        //******************FINALIZA INSERSION DE PRODUCTOS
         */

        productAdapter = new ProductAdapter(this,arrayProducts);
        listViewProducts.setAdapter(productAdapter);
        dbFirebase.getData(productAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);

                return true;

            case R.id.itemMap:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}