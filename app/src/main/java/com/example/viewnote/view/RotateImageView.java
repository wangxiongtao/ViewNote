package com.example.viewnote.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.viewnote.R;

public class RotateImageView extends androidx.appcompat.widget.AppCompatImageView {
    public RotateImageView(@NonNull Context context) {
        super(context);
        init();
    }

    public RotateImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotateImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"sadas",Toast.LENGTH_LONG).show();
                RotateAnimation rotateAnimation=new RotateAnimation(0,360,v.getWidth()/2,v.getHeight()/2);
                rotateAnimation.setDuration(2000);
                startAnimation(rotateAnimation);
            }
        });
    }


}
