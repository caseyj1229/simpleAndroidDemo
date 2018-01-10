package com.example.jackc.gamedemo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by jackc on 1/10/2018.
 */

public class CharacterSprite {
    private Bitmap image;
    private int xPos;
    private int yPos;
    private int xVelocity = 4;
    private int yVelocity = 2;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels + 300;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;


    public CharacterSprite(Bitmap bitmap){
        image = bitmap;
        xPos = 100;
        yPos = 100;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image,xPos,yPos,null);
    }

    public void update() {
        xPos += xVelocity;
        yPos += yVelocity;
        if (xPos > screenWidth - image.getWidth() || (xPos < 0)) {
            xVelocity = xVelocity * -1;
        }
        if (yPos > screenHeight - image.getHeight() || yPos < 0) {
            yVelocity = yVelocity * -1;
        }

    }
}
