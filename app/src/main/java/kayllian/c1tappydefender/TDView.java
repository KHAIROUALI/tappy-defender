package kayllian.c1tappydefender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by dvan_ on 11/10/2017.
 * The view for the Tappy Defender
 */

public class TDView extends SurfaceView implements Runnable {

    volatile boolean playing;
    private Thread gameThread;
    private PlayerShip player;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;
    private EnemyShip[] enemies;
    private ArrayList<SpaceDust> dust = new ArrayList<>();

    public TDView(Context context, int x, int y) {
        super(context);
        ourHolder =  getHolder();
        paint = new Paint();
        player = new PlayerShip(context, x, y);
        enemies = new EnemyShip[3];

        for (int i = 0; i < enemies.length; i++)
            enemies[i] = new EnemyShip(context, x, y);

        int numSpecs = 40;
        for(int i = 0; i < numSpecs; i++){
            SpaceDust spec = new SpaceDust(x, y);
            dust.add(spec);
        }
    }

    @Override
    public void run() {
        while(playing){
            update();
            draw();
            control();            
        }
    }

    public void pause(){
        playing = false;

        try{
            gameThread.join();
        }catch(InterruptedException e){

        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void control() {
        try {
            gameThread.sleep(17);
        }catch(InterruptedException ex){

        }

    }

    private void draw() {
        if(ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();

            canvas.drawColor(Color.argb(255, 0, 0, 0));

            canvas.drawBitmap(player.getBitmap(), player.getX(), player.getY(), paint);
            for (int i = 0; i < enemies.length; i ++) {
                EnemyShip enemy = enemies[i];
                canvas.drawBitmap(enemy.getBitmap(), enemy.getX(), enemy.getY(), paint);
            }

            paint.setColor(Color.argb(255, 255, 255, 255));
            for(SpaceDust particle : dust) {
                canvas.drawPoint(particle.getX(), particle.getY(), paint);
            }

            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        int action = motionEvent.getAction();
        switch(action & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                player.stopBoosting();
                break;
            case MotionEvent.ACTION_DOWN:
                player.boost();
                break;
        }

        return true;
    }

    private void update() {
        player.update();

        for (int i = 0; i < enemies.length; i++){
            enemies[i].update(player.getSpeed());
        }

        for(SpaceDust particle : dust) {
            particle.update(player.getSpeed());
        }
    }

}
