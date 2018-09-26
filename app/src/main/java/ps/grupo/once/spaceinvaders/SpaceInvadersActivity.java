package ps.grupo.once.spaceinvaders;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class SpaceInvadersActivity extends Activity {

    SpaceInvadersView spaceInvadersView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sgao 20180926 determinar si es un baby
        Bundle extras = getIntent().getExtras();
        final boolean isAdult = extras.getBoolean("adult");
        Log.d("En SpaceInvaders", "el resultado es " + isAdult);

        // get the screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // set the gameview to spaceInvadersView
        spaceInvadersView = new SpaceInvadersView(this, size, isAdult);
        setContentView(spaceInvadersView);
    }

    // when our app goes out of focus
    @Override
    protected void onPause() {
        super.onPause();
        spaceInvadersView.pause();
    }

    // when our app gains focus
    @Override
    protected void onResume() {
        super.onResume();
        spaceInvadersView.resume();
    }

    // when activity is stopped
    @Override
    protected void onStop() {
        super.onStop();
        spaceInvadersView.stop();
    }
}
