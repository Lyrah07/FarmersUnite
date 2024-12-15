package com.example.farmersunite.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.farmersunite.Domain.ItemsDomain;

import java.util.ArrayList;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertItem(ItemsDomain item){
        ArrayList<ItemsDomain> listitem= getListCart();
        boolean existAlready=false;
        int n=0;
        for (int y = 0; y < listitem.size(); y++) {
            if (listitem.get(y).getTitle().equals(item.getTitle())) {
                existAlready= true;
                n=y;
                break;
            }
        }
        if (existAlready) {
            listitem.get(n).setNumberinCart(item.getNumberinCart());
        }else {
            listitem.add(item);
        }
        tinyDB.putListObject("Cart_list", listitem);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ItemsDomain> getListCart(){
        return tinyDB.getListObject("Cart_list");

    }
}
