package com.example.viewnote.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.viewnote.R;


public class MyView2 extends View {
    Paint paint;
    Paint paint2;
    Handler handler;
    int w=0;
    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        paint2=new Paint();
        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.FILL);

        handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                w+=100;
                if(w>=1290){
                    handler.removeCallbacksAndMessages(null);
                    return;
                }
                invalidate();
            }
        };
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(800,800);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#AAAAAA")); //绘制蓝色
        canvas.translate(400,400);
//        canvas.drawLine(0,0,400,0,paint);
        canvas.drawCircle(0,0,400,paint);
        canvas.drawCircle(0,0,140,paint2);
        canvas.drawLine(200,100,400,0,paint);
        canvas.save();//把当前的状态保存
        int degrees=10;
//        canvas.rotate(degrees);
//        canvas.drawLine(100,100,400,0,paint);
        for (int i=degrees;i<=360;i+=degrees){
            canvas.drawLine(100,100,400,0,paint);
            canvas.rotate(degrees);
        }
        canvas.restore();//还原最近一次的保存状态
        canvas.drawLine(200,100,400,0,paint);

        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.success);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.game);
        Rect src = new Rect(w,0,w+100,100);
//        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(-100,-100,100,100);
        // 绘制图片
        canvas.drawBitmap(bitmap,src,dst,paint);
        handler.sendEmptyMessageDelayed(10,50);


    }
}
