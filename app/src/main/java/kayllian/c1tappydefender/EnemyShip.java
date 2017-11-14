package kayllian.c1tappydefender;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class EnemyShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed;
    private int maxY, minY;
    private int maxX, minX;

    public EnemyShip(Context context, int maxX, int maxY){
        Random generator = new Random();
        speed = generator.nextInt(6) + 10;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        minX = minY = 0;

        this.maxX = x = maxX;
        this.y = generator.nextInt(maxY) - (int)(1.5 * bitmap.getHeight());
        this.maxY = maxY;
    }

    public void update(int playerSpeed) {
        x -= (playerSpeed + speed);

        if(x < minX - bitmap.getWidth()){
            Random generator = new Random();
            speed = generator.nextInt(10) + 10;
            x = maxX;
            y = generator.nextInt(maxY) - bitmap.getHeight();
        }
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
