package ps.grupo.once.spaceinvaders.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import ps.grupo.once.spaceinvaders.R;
import ps.grupo.once.spaceinvaders.SpaceInvadersActivity;

public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_age);

        final Button adultButton = (Button) this.findViewById(R.id.adult);
        adultButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("debug", "selected adult");
                Intent intent = new Intent(MainActivity.this, SpaceInvadersActivity.class);
                intent.putExtra("adult", true);
                startActivity(intent);
            }
        });

        final Button babyButton = (Button) this.findViewById(R.id.baby);
        babyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("debug", "selected baby");
                Intent intent = new Intent(MainActivity.this, SpaceInvadersActivity.class);
                intent.putExtra("adult", false);
                startActivity(intent);
            }
        });
    }
}
