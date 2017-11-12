package kayllian.c1tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by dvan_ on 11/11/2017.
 */

public class PlayerShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed;

    public PlayerShip(Context context){
        y = 50;
        x = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
    }

    public void update() {
        x += 1;
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
