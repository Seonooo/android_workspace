package kr.or.dshrd.exam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

        Button calllogin, callsign;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                calllogin = findViewById(R.id.main_login);
                calllogin.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                                Intent intent = new Intent(Main.this, Login.class);
                                startActivity(intent);
                        }
                });
                callsign = findViewById(R.id.main_sign_up);
                callsign.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                                Intent intent = new Intent(Main.this, Sign_up.class);
                                startActivity(intent);
                        }
                });
        }
}
