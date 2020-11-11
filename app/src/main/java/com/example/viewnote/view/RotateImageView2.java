package com.example.viewnote.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RotateImageView2 extends androidx.appcompat.widget.AppCompatImageView {
    public RotateImageView2(@NonNull Context context) {
        super(context);
        init();
    }

    public RotateImageView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotateImageView2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        setRotation(-20);
    }


}
