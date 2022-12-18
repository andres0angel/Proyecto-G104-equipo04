package com.example.proyecto.DB;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyecto.Adapters.ProductAdapter;
import com.example.proyecto.Entities.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase(){
        db = FirebaseFirestore.getInstance();
    }

    public void insertData(Product producto){
        // Create a new user with a first and last name
        Map<String, Object> prod = new HashMap<>();
        prod.put("id", producto.getId());
        prod.put("name", producto.getName());
        prod.put("description", producto.getDescription());
        prod.put("price", producto.getPrice());
        prod.put("image", producto.getImage());
        prod.put("latitud", producto.getLatitud());
        prod.put("longitud", producto.getLongitud());

        // Add a new document with a generated ID
        db.collection("Productos").add(prod);
    }


    public void getData(ProductAdapter adapter){
        db.collection("Productos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Product> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product producto = new Product(
                                        document.getData().get("id").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        Integer.parseInt(document.getData().get("price").toString()),
                                        document.getData().get("image").toString(),
                                        document.getData().get("latitud").toString(),
                                        document.getData().get("longitud").toString()
                                );
                                list.add(producto);
                            }
                            adapter.setArrayProduct(list);
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }


    public void deleteData(String id){
        db.collection("Productos").whereEqualTo("id",id)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Product> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                document.getReference().delete();
                            }
                        }
                    }
                });
    }

    public void updateData(Product product){
        db.collection("Productos").whereEqualTo("id",product.getId())
        .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Product> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                document.getReference().update(
                                        "name", product.getName(),
                                        "description", product.getDescription(),
                                        "price", product.getPrice(),
                                        "image", product.getImage(),
                                        "latitud", product.getLatitud(),
                                        "lognitud", product.getLongitud()
                                );
                            }
                        }
                    }
                });
    }


}
