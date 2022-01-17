package kr.or.dshrd.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

import kr.or.dshrd.challenge.HelperClass.ItemHelperClass;
import kr.or.dshrd.challenge.HelperClass.itemAdapter;

public class ItemCategories extends AppCompatActivity {

    RecyclerView itemRecycler;
    RecyclerView.Adapter adapter;


    public ItemCategories(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        itemRecycler = findViewById(R.id.list_view);
    }

    private void itemRecycler(){
        itemRecycler.setHasFixedSize(true);
        itemRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<ItemHelperClass> itemLocation = new ArrayList<>();
        itemLocation.add(new ItemHelperClass("1", "naan","aksdk","2022-01-17"));
        itemLocation.add(new ItemHelperClass("1", "naan","aksdk","2022-01-17"));
        itemLocation.add(new ItemHelperClass("1", "naan","aksdk","2022-01-17"));

        adapter = new itemAdapter(itemLocation);
        itemRecycler.setAdapter(adapter);

    }
}