package kayllian.c1tappydefender;

import java.util.Random;

public class SpaceDust {
    private int x, y;
    private int minX, minY;
    private int maxX, maxY;
    private int speed;

    public SpaceDust(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        minY = minX = 0;

        Random generator = new Random();
        speed = generator.nextInt(10);
        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(int playerSpeed) {
        x -= (playerSpeed + speed);

        if(x < minX) {
            x = maxX;
            Random generator = new Random();
            speed = generator.nextInt(15);
            y = generator.nextInt(maxY);
        }
    }
}
