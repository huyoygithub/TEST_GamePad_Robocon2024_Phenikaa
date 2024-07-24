package com.example.connectmqtt.stateLeft;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.connectmqtt.R;
import com.example.connectmqtt.databinding.FragmentManualBinding;
import com.google.android.material.slider.Slider;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Manual extends Fragment {

    private final OkHttpClient client = new OkHttpClient();


    private FragmentManualBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManualBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onClick();

        handleSwitch();
        handelSlider();
    }

    private void handelSlider() {
        binding.sldVertical.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                binding.sldVertical.setValue(0);

            }
        });
        binding.sldVertical.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int valueSpeed = 255-(int)Math.abs(value);
                String valueStr=String.valueOf(valueSpeed);

                String strCMD = "";

                if (value > 0) {
                    strCMD = "MF";
                    sendCommand(strCMD + valueStr);
                } else if (value < 0) {
                    strCMD = "MB";
                    sendCommand(strCMD + valueStr);

                } else {
                    strCMD = "Stop";
                    sendCommand(strCMD  );
                }

            }
        });

        binding.sldHorizontal.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                binding.sldHorizontal.setValue(0);

            }
        });
        binding.sldHorizontal.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int valueSpeed =255- (int)Math.abs(value) ;
                String valueStr=String.valueOf(valueSpeed);

                String strCMD = "";

                if (value > 0) {
                    strCMD = "MR";
                    sendCommand(strCMD + valueStr);
                } else if (value < 0) {
                    strCMD = "ML";
                    sendCommand(strCMD + valueStr);

                } else {
                    strCMD = "Stop";
                    sendCommand(strCMD);
                }

            }
        });

    }


    private void handleSwitch() {


//        if (binding.swAllRight.is()){
//            binding.sw3.setChecked(true);
//            binding.sw4.setChecked(true);
//        }
//        if (binding.sw3.isChecked()&&binding.sw4.isChecked()){
//            binding.swAllRight.setChecked(true);
//        }

        binding.swHut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("HUT_ON");
                } else {
                    sendCommand("HUT_OFF");


                }


            }
        });
        binding.swNangSung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("XL_NANG_SUNG_ON");

                } else {
                    sendCommand("XL_NANG_SUNG_OFF");

                }


            }
        });
 
        binding.swNangKhung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("XL_NANG_KHUNG_ON");
                } else {
                    sendCommand("XL_NANG_KHUNG_OFF");
                }
            }
        });
//
//        binding.swAllLeft.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked) {
//                    sendCommand("ALL_LEFT_ON");
//                } else {
//                    sendCommand("ALL_LEFT_OFF");
//                }
//
//
//            }
//        });
//        binding.swAllRight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked) {
//                    sendCommand("ALL_RIGH_ON");
//                } else {
//                    sendCommand("ALL_RIGH_OFF");
//                }
//
//
//            }
//        });
        binding.sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("TK13_ON");
                } else {
                    sendCommand("TK13_OFF");
                }


            }
        });

        binding.sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("TK2_ON");
                } else {
                    sendCommand("TK2_OFF");
                }


            }
        });

        binding.sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("TK46_ON");
                } else {
                    sendCommand("TK46_OFF");
                }


            }
        });
        binding.sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sendCommand("TK5_ON");
                } else {
                    sendCommand("TK5_OFF");
                }
            }
        });


    }

    @SuppressLint("ClickableViewAccessibility")
    private void onClick() {


        binding.btnShoot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        sendCommand("SHOOT");
                        return true;
                    case MotionEvent.ACTION_UP:
                        sendCommand(" ");
                        return true;
                }
                return false;
            }
        });

        binding.btnRotary.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        sendCommand("ROTARY");
                        return true;
                    case MotionEvent.ACTION_UP:
                        sendCommand(" ");
                        return true;
                }
                return false;
            }
        });



        binding.btnRotaryLeft45.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        sendCommand("RL");

                        v.performClick();
                        return true;
                    case MotionEvent.ACTION_UP:
                        sendCommand(" ");

                        v.performClick();

                        return true;
                }
                return false;
            }
        });
        binding.btnRotaryRight45.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        sendCommand("RR");
                        v.performClick();
                        return true;
                    case MotionEvent.ACTION_UP:
                        sendCommand(" ");

                }
                return false;
            }
        });



        binding.btnShoot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        sendCommand("SHOT");
                        view.performClick();
                        return true;
                    case MotionEvent.ACTION_UP:
                        sendCommand("C_SHOT");
                        view.performClick();

                        return true;
                }
                return false;
            }
        });

    }


    public void sendCommand(String cmd) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String command = "http://192.168.4.1/" + cmd;
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


                    requireActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.txtState.setText(cleanResponse);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}