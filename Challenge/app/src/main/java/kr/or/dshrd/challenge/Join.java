package kr.or.dshrd.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.or.dshrd.challenge.Common.OnBoarding;

public class Join extends AppCompatActivity {

    Button join, login;
    ImageView back;
    SharedPreferences OnBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        back = findViewById(R.id.join_back);
        join = findViewById(R.id.join_join);
        login = findViewById(R.id.join_login);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnBoardingScreen = getSharedPreferences("OnBoarding", MODE_PRIVATE);
                boolean isFirstTime =OnBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){
                    SharedPreferences.Editor editor =OnBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(Join.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(Join.this, MainHome.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}