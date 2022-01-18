package kr.or.dshrd.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class LottieAnim extends AppCompatActivity {

    TextView apptit;
    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_anim);

        // Hooks
        apptit = findViewById(R.id.app_title);
        lottie = findViewById(R.id.lottie);

        // animation
        apptit.animate().translationY(-1400).setDuration(2500).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2500).setStartDelay(3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), GoogleMap.class);
                startActivity(intent);
            }
        }, 5000);
    }
}