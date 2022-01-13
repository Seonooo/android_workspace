package kr.or.dshrd.splash_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.SearchBottomAdapter;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.SearchHelperClassBottom;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.SearchTopAdapter;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.SearchHelperClassTop;

public class ListAll extends AppCompatActivity {

    RecyclerView search_top_recyclerview, search_bottom_recyclerview;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);

        ArrayList<SearchHelperClassTop> searchtopLocation = new ArrayList<>();
        ArrayList<SearchHelperClassBottom> searchbottomLocation = new ArrayList<>();

        //Hooks
        search_top_recyclerview = findViewById(R.id.search_top_recyclerview);
        adapter = new SearchTopAdapter(searchtopLocation);
        search_top_recyclerview.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL,false));
        search_top_recyclerview.setAdapter(adapter);

        search_bottom_recyclerview = findViewById(R.id.search_bottom_recyclerview);
        adapter = new SearchBottomAdapter(searchbottomLocation);
        search_bottom_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        search_bottom_recyclerview.setAdapter(adapter);





        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_01"));
        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_02"));
        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_03"));
        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_04"));
        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_05"));
        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_06"));
        searchtopLocation.add(new SearchHelperClassTop(R.drawable.pro_img_03, "Pro_07"));


        searchbottomLocation.add(new SearchHelperClassBottom(R.drawable.pro_img_04, "Apple", "2020 Apple iPad Air 10.9", "★★★☆☆"));
        searchbottomLocation.add(new SearchHelperClassBottom(R.drawable.pro_img_04, "Apple", "2020 Apple iPad Air 10.9", "★★★☆☆"));
        searchbottomLocation.add(new SearchHelperClassBottom(R.drawable.pro_img_04, "Apple", "2020 Apple iPad Air 10.9", "★★★☆☆"));
        searchbottomLocation.add(new SearchHelperClassBottom(R.drawable.pro_img_04, "Apple", "2020 Apple iPad Air 10.9", "★★★☆☆"));
        searchbottomLocation.add(new SearchHelperClassBottom(R.drawable.pro_img_04, "Apple", "2020 Apple iPad Air 10.9", "★★★☆☆"));
        searchbottomLocation.add(new SearchHelperClassBottom(R.drawable.pro_img_04, "Apple", "2020 Apple iPad Air 10.9", "★★★☆☆"));


    }
}