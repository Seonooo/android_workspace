package kr.or.dshrd.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.or.dshrd.challenge.HelperClass.ItemHelperClass;
import kr.or.dshrd.challenge.HelperClass.itemAdapter;

public class ItemCategories extends AppCompatActivity {

    ImageView back;
    RecyclerView itemRecycler;
    RecyclerView.Adapter adapter;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        add = findViewById(R.id.item_add);
        back = findViewById(R.id.list_back);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "추가 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), MainHome.class);
                startActivity(intent);
            }
        });



        ArrayList<ItemHelperClass> itemLocation = new ArrayList<>();
        itemRecycler = findViewById(R.id.list_view);
        adapter = new itemAdapter(itemLocation);
        itemRecycler.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.VERTICAL,false));
        itemRecycler.setAdapter(adapter);
        itemLocation.add(new ItemHelperClass("no", "title","content","hit","date"));
        itemLocation.add(new ItemHelperClass("1", "naan","aksdk","3","2022-01-17"));
        itemLocation.add(new ItemHelperClass("1", "naan","aksdk","3","2022-01-17"));
        itemLocation.add(new ItemHelperClass("1", "naan","aksdk","3","2022-01-17"));
    }


}

