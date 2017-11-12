package kayllian.c1tappydefender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    TDView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new TDView(this);
        setContentView(gameView);
    }

    @Override
    protected void onPause(){
        super.onPause();

        gameView.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();

        gameView.resume();
    }
}
