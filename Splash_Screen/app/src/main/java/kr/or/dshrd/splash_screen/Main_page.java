package kr.or.dshrd.splash_screen;

import static androidx.recyclerview.widget.RecyclerView.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.CateAdapter;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.OrderAdapter;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.OrderHelperClass;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.CateHelperClass;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.ProAdapter;

public class Main_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // 선언
    static final float END_SCALE = 0.7f;
    RecyclerView orderRecycler, proRecycler, cateRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4 ;
    ImageView menuicon;
    LinearLayout contenView;

    // Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // Hooks
        orderRecycler = findViewById(R.id.order_recycler);
        proRecycler = findViewById(R.id.pro_recycler);
        cateRecycler = findViewById(R.id.cate_recycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuicon = findViewById(R.id.menu_icon);

        contenView = findViewById(R.id.conten);


        navigationDrawer();
        orderRecycler();
        proRecycler();
        cateRecycler();
    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuicon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Navigation animation 처리

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        //메뉴바 열었을 때 뒤에 색변경
        drawerLayout.setScrimColor(getResources().getColor(R.color.design_default_color_on_primary));

        //메뉴바 열었을 때 오른쪽으로 화면 옮기기
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // view 사이즈크기 설정
                final float diffScaledOffset = slideOffset * (1- END_SCALE);
                final float offsetScale = 1-diffScaledOffset;
                contenView.setScaleX(offsetScale);
                contenView.setScaleY(offsetScale);

                super.onDrawerSlide(drawerView, slideOffset);

                // translatate 설정
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contenView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contenView.setTranslationX(xTranslation);
            }
        }); {



        };

    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    //좌측메뉴 클릭시 Activity 이동



    // recyclerview 노출할 화면 사이즈 픽스
    private void orderRecycler() {

        orderRecycler.setHasFixedSize(true);
        orderRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<OrderHelperClass> orderLocation = new ArrayList<>();
        orderLocation.add(new OrderHelperClass(R.drawable.order_01, "Apple Watch", "★★☆☆☆","Available when you purchase any new iPhone, iPad, iPod Touch."));
        orderLocation.add(new OrderHelperClass(R.drawable.order_02, "Apple ipad Air", "★☆☆☆☆"," you purchase any new iPhone, iPad, iPod Touch."));
        orderLocation.add(new OrderHelperClass(R.drawable.order_03, "Apple Pro_01", "★★★★☆","iPhone, iPad, iPod Touch."));
        //Adapter

        adapter = new OrderAdapter(orderLocation);
        orderRecycler.setAdapter(adapter);
    }

    private void proRecycler() {

        proRecycler.setHasFixedSize(true);
        proRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<OrderHelperClass> proLocation = new ArrayList<>();
        proLocation.add(new OrderHelperClass(R.drawable.pro_01, "Apple Watch", "★★☆☆☆","Available when you purchase any new iPhone, iPad, iPod Touch."));
        proLocation.add(new OrderHelperClass(R.drawable.order_02, "Apple ipad Air", "★★★★★"," you purchase any new iPhone, iPad, iPod Touch."));
        proLocation.add(new OrderHelperClass(R.drawable.order_03, "Apple Pro_01", "★★★★☆","aksldfnj"));

        //Adapter
        adapter = new ProAdapter(proLocation);
        proRecycler.setAdapter(adapter);
    }

    private void cateRecycler(){

        // Gradient
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xFFC6A6FF});
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xFFC6A6FF});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xFFC6A6FF});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xFFC6A6FF});

        cateRecycler.setHasFixedSize(true);
        cateRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<CateHelperClass> cateLocation = new ArrayList<>();
        cateLocation.add(new CateHelperClass(R.drawable.cate_01, "Wearable", gradient1));
        cateLocation.add(new CateHelperClass(R.drawable.cate_02, "Laptops",gradient2));
        cateLocation.add(new CateHelperClass(R.drawable.cate_01, "Wifi",gradient3));
        cateLocation.add(new CateHelperClass(R.drawable.cate_02, "Go",gradient4));

        adapter = new CateAdapter(cateLocation);
        cateRecycler.setAdapter(adapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_products:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;



        }


        return false;
    }
}