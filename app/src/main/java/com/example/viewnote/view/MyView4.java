package com.example.viewnote.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class MyView4 extends View {
    ValueAnimator valueAnimator;
    float start=100;
    float start1=10;
    Paint paint;
    public MyView4(Context context) {
        super(context);
        init();
    }

    public MyView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        valueAnimator=ValueAnimator.ofFloat(0,1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i("aaaa","==onAnimationUpdate===>"+animation.getAnimatedValue());
               if(start>1000){
                   start=100;
                   start1=10;
               }else {
                   float a= (float) animation.getAnimatedValue();
                   start=1000*a;
                   start1=500*a;
               }
               invalidate();

            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint=new Paint();
        paint.setStrokeWidth(30);
        paint.setColor(Color.RED);

        Paint paint2=new Paint();
        paint2.setStrokeWidth(10);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(Color.BLUE);
        RectF rectF=new RectF(0,0,200,200);
        canvas.drawRect(rectF,paint2);


        Path path=new Path();
        path.moveTo(100,50);
        path.quadTo(-100,-100,100,200);
        path.close();
        canvas.drawPath(path,paint);
        path.reset();
//        path.moveTo(100,100);
//        path.quadTo(200,0,200,200);
//        path.close();
//        canvas.drawPath(path,paint);
        canvas.translate(getWidth()/2,getWidth()/2);
        path.addCircle(0,0,100, Path.Direction.CCW);
        path.close();
        PathMeasure measure = new PathMeasure(path, true);

        Path dst = new Path();
        measure.getSegment(0, start+100, dst, true);

        canvas.drawPath(dst, paint2);

        path.reset();
        path.moveTo(-200,0);
        path.lineTo(-100,100);
        path.lineTo(300,-100);


        PathMeasure measure2 = new PathMeasure(path, false);

        Path dst2 = new Path();
        measure2.getSegment(0, start1+10, dst2, true);

        canvas.drawPath(dst2, paint2);
        Region region=new Region();
        paint.setPathEffect(new CornerPathEffect(200));

    }
}
