package com.example.farmersunite.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.farmersunite.Adapter.SimilarAdapter;
import com.example.farmersunite.Domain.ItemsDomain;
import com.example.farmersunite.Helper.ManagmentCart;
import com.example.farmersunite.R;

public class DetailActivity extends AppCompatActivity {
private ItemsDomain object;
private ImageView backBtn,itemImg;
private TextView priceKgTxt,titleTxt,descriptionTxt,ratingTxt;
private RatingBar ratingBar;
private TextView scaleTxt,plusBtn,minusBtn,totalTxt;
private int weight=1;
private RecyclerView.Adapter similarAdapter;
private RecyclerView recyclerViewSimilar;
private int numberOrder = 1;
private Button addTocartBtn;
private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getBundles();
        initView();
        setVariable();
        initSimilarList();

        managmentCart= new ManagmentCart(DetailActivity.this);
    }

    private void initSimilarList() {
        recyclerViewSimilar = findViewById(R.id.similarView);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        similarAdapter = new SimilarAdapter(new ShopActivity().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);
    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());

        int drawabaleResourceId = getResources().getIdentifier(object.getImgPath(),"drawable",DetailActivity.this.getPackageName());

        Glide.with(DetailActivity.this)
                .load(drawabaleResourceId)
                .into(itemImg);

        priceKgTxt.setText(object.getPrice()+"₱/kg");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingTxt.setText("("+object.getRate()+")");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText(weight*object.getPrice()+"₱");


        plusBtn.setOnClickListener(v -> {
            weight = weight + 1;
            scaleTxt.setText(weight+" kg");
            totalTxt.setText(weight*object.getPrice()+"₱");
        });

        minusBtn.setOnClickListener(v -> {
            if(weight>1){
                weight = weight-1;
                scaleTxt.setText(weight+" kg");
                totalTxt.setText(weight*object.getPrice()+"₱");
            }
        });

        addTocartBtn.setOnClickListener(v -> {
            object.setNumberinCart(weight);
            managmentCart.insertItem(object);
        });
//        addTocartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(DetailActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    private void initView() {
        backBtn = findViewById(R.id.backBtn);
        itemImg = findViewById(R.id.img);
        priceKgTxt = findViewById(R.id.priceKgTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        ratingBar = findViewById(R.id.ratingBar);
        ratingTxt = findViewById(R.id.ratingTxt);
        scaleTxt = findViewById(R.id.scaleTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        totalTxt = findViewById(R.id.totalTxt);
    }

    private void getBundles() {
        object = (ItemsDomain) getIntent().getSerializableExtra("object");


    }
}