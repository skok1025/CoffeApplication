package com.kimsh.skok.angel_in_us;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Splash extends AppCompatActivity {
    Handler handler = new Handler();
    ImageView waterImage;
    ImageView lotteImage;
    Animation dropAnimation;
    Animation flowAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // water 이미지에 애니메이션 객체 설정
        waterImage = (ImageView) findViewById(R.id.angelsp);
        dropAnimation = AnimationUtils.loadAnimation(this, R.anim.drop);
        waterImage.setAnimation(dropAnimation);

        lotteImage = (ImageView) findViewById(R.id.lotte);
        flowAnimation = AnimationUtils.loadAnimation(this,R.anim.flow);
        lotteImage.setAnimation(flowAnimation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish(); // 2.3 초후 이미지를 닫아버림
            }
        }, 2300);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            dropAnimation.start();
            flowAnimation.start();

        } else {
            dropAnimation.reset();
            flowAnimation.reset();
        }

    }

}