package com.example.jackc.gamedemo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by jackc on 1/8/2018.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
    private MainThread thread;
    private CharacterSprite sprite;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        sprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(), R.drawable.character));

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        sprite.update();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            canvas.drawColor(Color.WHITE);
            sprite.draw(canvas);
/*
            Paint paint = new Paint();
            Paint paint2 = new Paint();
            //paint.setColor(Color.RED);
            paint2.setColor(Color.BLUE);

            //canvas.drawRect(200,200,500,500,paint);
            canvas.drawRect(100,100,250,250,paint2);*/
        }
    }
}
