package org.choongang.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // 인플레이션 xml -> 자바 객체로 변환 (돔과비슷)

//        Button button = findViewById(R.id.button);  // <Button android:id="@+id/button"
//        Log.i("BUTTON", button.toString());
    }

    public void onButton1Click(View v){
        // 알림메시지
        Toast.makeText(this, "버튼 클릭", Toast.LENGTH_LONG).show();
        //Toast.LENGTH_LONG : 길게 보여지고 사라지는
        //Toast.LENGTH_SHORT : 잠깐 보였다가 사라지는
    }

    public void onButton2Click(View v){
        // 링크연결
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
        // Intent(액션관련된 상수, URL주소)
        // Intent : 데이터 전달자(암묵적)
        startActivity(intent);
    }

    public void onButton3Click(View v){
        // 전화하기
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-5678"));
        startActivity(intent);
    }

}