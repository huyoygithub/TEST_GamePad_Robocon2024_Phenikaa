package com.example.connectmqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.connectmqtt.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {
    private boolean isFullScreen = false;
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setFullScreen();
        setContentView(binding.getRoot());
        checkFullScreen();
        switchActivity();


    }

    private void switchActivity() {
        binding.animationView.setSpeed(2.0f);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_center, R.anim.slide_out_center);

                finish();
            }
        }, 3000);

    }

    private void setFullScreen() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    private void checkFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnPreDrawListener(() -> {
            // Kiểm tra trạng thái toàn màn hình và thực hiện chuyển đổi nếu cần
            if (!isFullScreen) {
                setFullScreen();
                isFullScreen = true;
            }
            return true;
        });
    }
}