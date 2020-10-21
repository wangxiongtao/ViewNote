package com.example.viewnote.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    Paint paint;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(400,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#AAAAAA")); //绘制蓝色
//        canvas.drawPoint(getWidth()/2,getHeight()/2,paint);
        canvas.drawLine(0,0,400,0,paint);
        canvas.drawLine(400,0,400,100,paint);
        canvas.drawLine(400,100,0,100,paint);
        canvas.drawLine(0,0,0,0,paint);

        RectF rect=new RectF(200,200,400,500);
        canvas.drawRoundRect(rect,150,100,paint);
        Path path=new Path();
        path.lineTo(0,0);
        path.lineTo(0,300);
        path.lineTo(100,100);
        path.lineTo(100,0);
        path.close();
//        canvas.clipPath(path);
//        canvas.drawColor(Color.parseColor("#ff0000")); //绘制蓝色
        canvas.translate(100,100);

        canvas.drawCircle(100,100,100,paint);




    }
}
