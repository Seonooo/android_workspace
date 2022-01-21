package kr.or.dshrd.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.or.dshrd.challenge.Common.OnBoarding;

public class Login extends AppCompatActivity {

    Button login, join;
    ImageView back;
    SharedPreferences OnBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        back = findViewById(R.id.login_back);
        login = findViewById(R.id.login_login);
        join = findViewById(R.id.login_join);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnBoardingScreen = getSharedPreferences("OnBoarding", MODE_PRIVATE);
                boolean isFirstTime =OnBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){
                    SharedPreferences.Editor editor =OnBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(Login.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(Login.this, MainHome.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });

    }
}