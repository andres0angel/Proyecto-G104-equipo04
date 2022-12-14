package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


import com.example.proyecto.Adapters.ProductAdapter;
import com.example.proyecto.Entities.Product;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProducts = new ArrayList<>();
        //CREACION DE PRODUCTOS
        Product productClarinete = new Product("Clarinete soprano","Clarinete en Bb marca Yamaha 45, hecho en madera.",1500000,R.drawable.clarinete);
        Product productCorno = new Product("Corno francés","Corno Marca Yamaha, hecho en bronce.",2500000,R.drawable.corno);
        Product productFagot = new Product("Fagot","Fagot Marca Yamaha serie 4A, hecho en madera.",8700000,R.drawable.fagot);
        Product productFlauta = new Product("Flauta traversa","Flauta soprano marca Júpiter, hecha en bronce.",900000,R.drawable.flauta);
        Product productSaxofon = new Product("Saxofon tenor","Saxofón tenor marca Jimbao, hecho en bronce.",1700000,R.drawable.saxofon);
        Product productTrombon = new Product("Trombón","Trombón marca Yamaha serie 100, hecho en bronce.",1100000,R.drawable.trombon);
        //Product productTrompeta = new Product("Trompeta","Trompeta en Bb marca Aristocrat, hecha en metal",950000,R.drawable.trompeta);
        Product productTuba = new Product("Tuba","Tuba marca Aristocrat 15, hecho en bronce.",9000000,R.drawable.tuba);


        arrayProducts.add(productClarinete);
        arrayProducts.add(productCorno);
        arrayProducts.add(productFagot);
        arrayProducts.add(productFlauta);
        arrayProducts.add(productSaxofon);
        arrayProducts.add(productTrombon);
        //arrayProducts.add(productTrompeta);
        arrayProducts.add(productTuba);
        //******************
        productAdapter = new ProductAdapter(this,arrayProducts);
        listViewProducts.setAdapter(productAdapter);
    }
}