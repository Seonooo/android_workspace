package kr.or.dshrd.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    //애니변수 지정
    Animation topanim, bottomanim;
    ImageView image;
    TextView tit1, tit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 상단 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //변수에 애니메이션 설정하기
        topanim= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //hooks
        image=findViewById(R.id.imageview);
        tit1=findViewById(R.id.title1);
        tit2=findViewById(R.id.title2);

        // 이미지와 텍스트에 애니메이션 연결
        image.setAnimation(topanim);
        tit1.setAnimation(bottomanim);
        tit2.setAnimation(bottomanim);

        //다음페이지 넘길 Splash 적용
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Main_page.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}