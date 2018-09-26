package ps.grupo.once.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.Vector;

public class Buttons extends SimplerButtons {

    // object's bitmap
    Bitmap shoot;

    // button location
    Point shootButtonLoc = new Point();

    // button rect
    Rect shootRect = new Rect();

    // buttons
    ButtonItem shootButton = new ButtonItem();

    public Buttons(Context context, int screenX, int screenY) {
        super(context, screenX, screenY);

        shootButtonLoc.x = screenX - length - (screenX / 100);
        shootButtonLoc.y = (screenY / 2) - (height / 2);

        shootRect.set(shootButtonLoc.x, shootButtonLoc.y, shootButtonLoc.x + length,
                shootButtonLoc.y + height);


        shoot = BitmapFactory.decodeResource(context.getResources(), R.drawable.shoot);

        shoot = Bitmap.createScaledBitmap(shoot, length, height, false);

        // set the buttons
        shootButton.rect = new Rect(shootRect);
        shootButton.action = Result.Shoot;

        buttons.addElement(shootButton);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas, paint);
        canvas.drawBitmap(shoot, shootButtonLoc.x, shootButtonLoc.y, paint);
    }
}
