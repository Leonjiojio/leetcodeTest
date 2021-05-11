package com.sinovoice.leetcodetest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * Created by  on 2021/5/11.
 **/
public class VelocityView extends View {
    private static  String TAG=VelocityView.class.getSimpleName();
    Paint p;
    Rect rect=new Rect();
    Scroller scroller;
    int height,width;
    public VelocityView(Context context) {
        super(context);
    }

    public VelocityView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VelocityView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public VelocityView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        intView(context);
    }
   private void intView(Context context){
       p=new Paint();
       p.setColor(Color.BLACK);
       p.setStyle(Paint.Style.FILL);
       scroller=new Scroller(context);
    }

    int rectWidth=0;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height=MeasureSpec.getSize(heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        rectWidth=width/4;
        rect.set((width-rectWidth)/2,(height-rectWidth)/2,(width-rectWidth)/2+rectWidth,(height-rectWidth)/2+rectWidth);
    }

    private boolean touchFocus =false;
    float distancx=0;
    float distancy=0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
//        Log.d(TAG, "onTouchEvent: x="+x+",y="+y);
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            touchFocus =inside(x,y);
            if (touchFocus){
                distancx=x-rect.left;
                distancy=y-rect.top;
            }
        }else
        if (event.getAction()==MotionEvent.ACTION_MOVE){
            if (touchFocus){
                rect.set((int)(x-distancx),(int)(y-distancy),(int)(x-distancx+rectWidth),(int)(y-distancy+rectWidth));
                invalidate();
            }
        }else if (event.getAction()==MotionEvent.ACTION_UP||event.getAction()==MotionEvent.ACTION_OUTSIDE){
            touchFocus =false;
        }

        return true;
    }

//    public void onScroll(){
//        int scroolX=getScrollX();
//        int scroolY=getScrollY();
//        int deltaX=width/2-scroolX;
//        int deltaY=height/2-scroolY;
//        scroller.startScroll(scroolX,scroolY,deltaX,deltaY,1000);
//        invalidate();
//    }
//
//    public void computeScroll() {
//        if (scroller.computeScrollOffset()){
//            scrollTo(scroller.getCurrX(),scroller.getCurrY());
//            postInvalidate();
//        }
//    }


    private boolean inside(float x,float y){
        return  x>=rect.left&&x<=rect.right&&y>=rect.top&&y<=rect.bottom;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        canvas.drawRect(rect,p);
    }
}
