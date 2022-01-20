package kr.or.dshrd.challenge.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.or.dshrd.challenge.HelperClass.SliderAdapter;
import kr.or.dshrd.challenge.MainHome;
import kr.or.dshrd.challenge.R;

public class OnBoarding extends AppCompatActivity {

    // 변수 선언
    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;

    Button letsGetStarted;

    Animation animation;

    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_boarding);

        // Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);

        // Call Adapter

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);
    }
    // Intent : 페이지 이동에 사용
    public void skip(View view){
        startActivity(new Intent(this, MainHome.class));
        finish();
    }
    public void next(View view){
        viewPager.setCurrentItem(currentPos + 1);
    }

    // dots 처리
    private void addDots(int position){

        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);

        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.purple_500));
        }
    }

    // 하단 버튼 (온보딩의 마지막화면에서 버튼 출력)처리 및 dots 색설정
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);

            currentPos = position;

            // 하단 버튼
            if(position == 0){
                letsGetStarted.setVisibility(viewPager.INVISIBLE);
            }
            else if (position == 1){
                letsGetStarted.setVisibility(viewPager.INVISIBLE);
            }
            else{
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.btn_anim);
                letsGetStarted.setAnimation(animation);

                letsGetStarted.setVisibility(viewPager.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}