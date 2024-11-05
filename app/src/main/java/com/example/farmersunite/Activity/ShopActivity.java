package com.example.farmersunite.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmersunite.Adapter.CategoryAdapter;
import com.example.farmersunite.Adapter.TopProductsAdapter;
import com.example.farmersunite.Domain.CategoryDomain;
import com.example.farmersunite.Domain.ItemsDomain;
import com.example.farmersunite.R;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {
    private RecyclerView.Adapter catAdapter,topProductsAdapter;
    private RecyclerView recyclerViewCat,recyclerViewTopProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        initRecyclerviewCat();
        initLocation();
        initRecyclerViewTopProducts();
    }

    private void initLocation() {
        String[] items=new String[]{"Baguio City, Philippines","Manila, Philippines","Cebu, Philippines"};
        final Spinner locationSpin= findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items=new ArrayList<>();
        items.add(new CategoryDomain("cat1","Vegetable"));
        items.add(new CategoryDomain("cat2","Fruit"));
        items.add(new CategoryDomain("cat3","Dairy"));
        items.add(new CategoryDomain("cat4","Drinks"));
        items.add(new CategoryDomain("cat5","Grain"));

        recyclerViewCat=findViewById(R.id.catView); //catView??//
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);

    }
    private void initRecyclerViewTopProducts(){
        recyclerViewTopProducts=findViewById(R.id.bestView);
        recyclerViewTopProducts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        topProductsAdapter = new TopProductsAdapter(getData());
        recyclerViewTopProducts.setAdapter(topProductsAdapter);
    }

    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain>items = new ArrayList<>();
        items.add(new ItemsDomain("orange","Fresh Orange",111.2,"Asim Kilig - Lorem ipsum Occaecat do esse ex et dolor culpa" +
                "nisi ex in magna consectetur nisi cupidatat laboris esse" +
                "eiusmod deserunt aute do quis velit esse sed Ut proident" +
                "cupidatat nulla esse cillum laborum occaecat nostrud sit" +
                "dolor incididunt amet est occaecat nisi.",4.2));
        items.add(new ItemsDomain("apple","Fresh apple",50.5,"Crispy Licious",4.3));
        items.add(new ItemsDomain("watermelon","Fresh watermelon",143,"Juicy Licious",4.8));
        items.add(new ItemsDomain("berry","Fresh berry",220.3,"Smallicious",4));
        items.add(new ItemsDomain("pineaplle","Fresh pineapple",86.8,"Pinellicious",3.7));
        items.add(new ItemsDomain("strawberry","Fresh strawberry",300,"Licious..",4.5));
        return items;
    }
}