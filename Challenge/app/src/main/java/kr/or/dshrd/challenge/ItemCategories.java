package kr.or.dshrd.challenge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

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

        ArrayList<ItemHelperClass> itemLocation = new ArrayList<>();
        itemRecycler = findViewById(R.id.list_view);
        adapter = new itemAdapter(this, itemLocation);
        itemRecycler.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.VERTICAL,false));
        itemRecycler.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ItemCategories.this);
                View view1 = LayoutInflater.from(ItemCategories.this).inflate(R.layout.add_dialog, null, false);
                builder.setView(view1);

                final Button DialogBtn = (Button) view1.findViewById(R.id.dialog_add);
                final EditText DialogNo = (EditText) view1.findViewById(R.id.dialog_no);
                final EditText DialogTitle = (EditText) view1.findViewById(R.id.dialog_title);
                final EditText DialogContent = (EditText) view1.findViewById(R.id.dialog_content);
                final EditText DialogDate = (EditText) view1.findViewById(R.id.dialog_date);

                DialogBtn.setText("추가하기");

                final AlertDialog dialog = builder.create();

                DialogBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String strNo = DialogNo.getText().toString();
                        String strTitle = DialogTitle.getText().toString();
                        String strContent = DialogContent.getText().toString();
                        String strDate = DialogDate.getText().toString();

                        ItemHelperClass dict = new ItemHelperClass(strNo, strTitle, strContent, strDate);
                        itemLocation.add(0,dict);

                        adapter.notifyItemInserted(0);

                        dialog.dismiss();


                    }
                });
                dialog.show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), MainHome.class);
                startActivity(intent);
            }
        });

        itemLocation.add(new ItemHelperClass("11", "11일차","운동","2022-01-21"));
        itemLocation.add(new ItemHelperClass("10", "10일차","독서","2022-01-20"));
        itemLocation.add(new ItemHelperClass("9", "9일차","운동","2022-01-19"));
        itemLocation.add(new ItemHelperClass("8", "8일차","독서","2022-01-18"));
        itemLocation.add(new ItemHelperClass("7", "7일차","운동","2022-01-17"));
        itemLocation.add(new ItemHelperClass("6", "6일차","독서","2022-01-16"));
        itemLocation.add(new ItemHelperClass("5", "5일차","운동","2022-01-15"));
        itemLocation.add(new ItemHelperClass("4", "4일차","독서","2022-01-14"));
        itemLocation.add(new ItemHelperClass("4", "4일차","독서","2022-01-14"));
        itemLocation.add(new ItemHelperClass("3", "3일차","운동","2022-01-13"));
        itemLocation.add(new ItemHelperClass("2", "2일차","독서","2022-01-12"));
        itemLocation.add(new ItemHelperClass("1", "1일차","운동","2022-01-11"));
    }
}

