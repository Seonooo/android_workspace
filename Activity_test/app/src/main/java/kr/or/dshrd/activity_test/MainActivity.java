package kr.or.dshrd.activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    public static final String TAG="Main";

    //Activity가 생성(실핼)될 때 자동으로 호출
    //화면회전이 발생할 때 자동으로 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");
    }

    // onCreate 메서드호출 이후 자동으로 호출
    // Activity가 정지 상태였다가 활동상태로 돌아올때 호출
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    // onStart 메서드 호출 이후에 자동으로 호출
    // Activity가 일시정지 되었다가 다시 돌아올 때
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    // Activity가 일시 정지 상태가 될때 호출
    // 화면상에서 완전히 사라지거나 현재 화면위에 팝업 창 같은것이 호출 될때
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    // Activity가 화면상에 사라졌을 때 호출
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    // Activity가 화면에서 완전히 종료되어 메모리상에서 제거 될 때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


}