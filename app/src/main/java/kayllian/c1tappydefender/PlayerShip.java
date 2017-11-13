package kayllian.c1tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.animation.GridLayoutAnimationController;

/**
 * Created by dvan_ on 11/11/2017.
 */

public class PlayerShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed;
    private boolean boosting;
    private final int GRAVITY = -12;

    private int maxY, minY;
    private int maxX, minX;


    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    public PlayerShip(Context context, int maxX, int maxY){
        y = 50;
        x = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
        boosting = false;
        minX = 0;
        minY = 0;

        this.maxX = maxX;
        this.maxY = maxY - (int)(1.5 * bitmap.getHeight());
    }

    public void update() {
        if(boosting)
            speed += 2;
        else
            speed -= 5;

        if(speed > MAX_SPEED)
            speed = MAX_SPEED;
        else if(speed < MIN_SPEED)
            speed = MIN_SPEED;

        y -= speed + GRAVITY;

        if(y < minY)
            y = minY;
        else if(y > maxY)
            y = maxY;

    }

    public void boost() {
        boosting = true;
    }

    public void stopBoosting() {
        boosting = false;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
