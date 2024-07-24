package com.example.connectmqtt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.connectmqtt.databinding.ActivityMainBinding;
import com.example.connectmqtt.stateLeft.ViewPagerAdapter;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    //    private final String topic = "huyhuyhuy/2302a";
    private ActivityMainBinding binding;
    //    private MQTTManager mqttManager;

    private boolean isFullScreen = false;
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //set full Screen
        setFullScreen();
        setContentView(binding.getRoot());
        checkFullScreen();
        binding.vpg2.setAdapter(new ViewPagerAdapter(this));
        //



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
    public void sendCommand(String cmd) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String command = "http://192.168.4.1/" + cmd;
                Log.d("Command------------------------------------------", command);
                Request request = new Request.Builder().url(command).build();
                try {
                    Response response = client.newCall(request).execute();
                    String myResponse = response.body().string();
                    final String cleanResponse = myResponse.replaceAll("\\<.*?\\>", ""); // remove HTML tags
                    cleanResponse.replace("\n", ""); // remove all new line characters
                    cleanResponse.replace("\r", ""); // remove all carriage characters
                    cleanResponse.replace(" ", ""); // removes all space characters
                    cleanResponse.replace("\t", ""); // removes all tab characters
                    cleanResponse.trim();
                    Log.d("Response  = ", cleanResponse);


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}