package com.example.connectmqtt;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomFABActionButton extends FloatingActionButton {
    public CustomFABActionButton(@NonNull Context context) {
        super(context);
    }

    public CustomFABActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFABActionButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent ev) {
        if (ev.getAction()==MotionEvent.ACTION_DOWN){
            Log.d("TAG", "onTouchEvent: ");



            performClick();
        }else if (ev.getAction()==MotionEvent.ACTION_UP){
            Log.d("TAG", "onTouchEvent: ");
            performClick();
        }

        return super.onTouchEvent(ev);

    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
