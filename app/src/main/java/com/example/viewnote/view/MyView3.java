package com.example.viewnote.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;


public class MyView3 extends View {
    Paint polygonPaint;
    Paint valuePaint;
    Paint textPaint;
    int w=0;
    int degrees;
    int polygonNum=9;
    int steps=5;
    double arc;
    int lineWidth=200;
    float demoValue[]={0.8f,0.5f,0.1f,0.63f,0.8f,0.9F};
    String texts []=new String[]{"观察力","观察力","观察力","观察力","观察力","观察力","观察力","观察力","观察力"};
    public MyView3(Context context) {
        super(context);
    }
    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        polygonPaint =new Paint();
        polygonPaint.setColor(Color.BLACK);
        polygonPaint.setStyle(Paint.Style.STROKE);
        polygonPaint.setStrokeWidth(5);

        valuePaint =new Paint();
        valuePaint.setColor(Color.parseColor("#88FF6600"));
        valuePaint.setStyle(Paint.Style.FILL);



        textPaint = new Paint();          // 创建画笔
        textPaint.setColor(Color.RED);        // 设置颜色
        textPaint.setStyle(Paint.Style.FILL);   // 设置样式
        textPaint.setTextSize(48);




    }

    public void setPolygonNum(int polygonNum) {
        this.polygonNum = polygonNum;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(800,800);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        degrees=360/polygonNum;
        arc=Math.PI*degrees/180;
//        Log.e("math","==Math=degrees=====>"+degrees);
        canvas.translate(400, 400);
        canvas.drawColor(Color.parseColor("#EFEFFE"));
        canvas.drawCircle(0,0,30, polygonPaint);
        canvas.save();



        for (int i=0;i<polygonNum;i++){//画中间的骨架线
            canvas.drawLine(0,0,lineWidth,0, polygonPaint);
            canvas.rotate(degrees);
        }
        Path path=new Path();
        for (int i=0;i<=steps;i++){//画周围的边线
            float p=(float)i/steps;
            path.reset();
            for (int j=0;j<polygonNum;j++){
                PointF pointF=getPointByValue(j,p);
                Log.e("math","==Math=pointF=====>"+pointF);
                if(j==0){
                    path.moveTo(pointF.x,pointF.y);
                }else {
                    path.lineTo(pointF.x,pointF.y);
                }
                if(p==1){
                    Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();

                    Rect rect = new Rect();
                    textPaint.getTextBounds(texts[j],0,texts[j].length(), rect);
                    float fontHeight = rect.height();
                    double angle=j*degrees;
                    if(angle==0||angle==360){//第一象限
                        canvas.drawText(texts[j], pointF.x,pointF.y+fontHeight/4,textPaint);
                    }else if(angle>0&&angle<=90){//第二象限
                        canvas.drawText(texts[j], pointF.x,pointF.y+fontHeight,textPaint);
                    }else if(angle>90&&angle<180){
                        float dis = textPaint.measureText(texts[j]);//文本长度
                        canvas.drawText(texts[j], pointF.x-dis,pointF.y+fontHeight,textPaint);
                    }else if(angle==180){
                        float dis = textPaint.measureText(texts[j]);//文本长度
                        canvas.drawText(texts[j], pointF.x-dis,pointF.y+fontHeight/4,textPaint);
                    }else if(angle>180&&angle<=270){
                        float dis = textPaint.measureText(texts[j]);//文本长度
                        canvas.drawText(texts[j], pointF.x-dis,pointF.y,textPaint);
                    }else if(angle>270&&angle<360){
                        float dis = textPaint.measureText(texts[j]);//文本长度
                        canvas.drawText(texts[j], pointF.x,pointF.y,textPaint);
                    }



//                    if(angle>=0&&angle<=90){//第1象限
//                        canvas.drawText(texts[j], pointF.x,pointF.y+fontHeight/4,textPaint);
//                    }else if(angle>90&&angle<=180){//第2象限
//                        canvas.drawText(texts[j], pointF.x,pointF.y+fontHeight/4,textPaint);
//                    }else if(angle>180&&angle<=270){//第3象限
//                        float dis = textPaint.measureText(texts[j]);//文本长度
//                        canvas.drawText(texts[j], pointF.x-dis,pointF.y-fontHeight/4,textPaint);
//                    }else if(angle>270&&angle<=360){//第1象限
//                        float dis = textPaint.measureText(texts[j]);//文本长度
//                        canvas.drawText(texts[j], pointF.x-dis,pointF.y-fontHeight/4,textPaint);
//                    }


                }

            }
            path.close();
            canvas.drawPath(path, polygonPaint);
        }







        Path path2=new Path();
        for (int j=0;j<demoValue.length;j++){//画给定点的坐标线
            PointF pointF=getPointByValue(j,demoValue[j]);
            Log.e("math","==Math=pointF=====>"+pointF);
            if(j==0){
                path2.moveTo(pointF.x,pointF.y);
            }else {
                path2.lineTo(pointF.x,pointF.y);
            }
        }
        path2.close();
        canvas.drawPath(path2, valuePaint);





















    }

    PointF getPointByValue(int index,float value){
        PointF point=new PointF();
        point.x= (float) (Math.cos(index*arc)*lineWidth*value);
        point.y= (float) (Math.sin(index*arc)*lineWidth*value);
        return point;
    }

















}
