package ps.grupo.once.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.Vector;

public class SimplerButtons {

    // object's bitmap
    Bitmap pause;

    public static enum Result {Pause, Shoot}

    ;

    // screen dimensions
    protected int screenX;
    protected int screenY;

    // button dimensions
    protected int length;
    protected int height;

    // button location
    Point pauseButtonLoc = new Point();

    // button rect
    Rect pauseRect = new Rect();

    // button specifications
    public class ButtonItem {
        public Rect rect;
        public Result action;
    }

    // vector to hold buttons
    protected Vector<ButtonItem> buttons = new Vector<ButtonItem>();

    // buttons
    ButtonItem pauseButton = new ButtonItem();

    public SimplerButtons(Context context, int screenX, int screenY) {

        this.screenX = screenX;
        this.screenY = screenY;

        length = screenY / 8;
        height = screenY / 8;


        pauseButtonLoc.x = (screenX / 2) - (length / 2);
        pauseButtonLoc.y = screenY / 100;


        pauseRect.set(pauseButtonLoc.x, pauseButtonLoc.y, pauseButtonLoc.x + length,
                pauseButtonLoc.y + height);

        pause = BitmapFactory.decodeResource(context.getResources(), R.drawable.pause);
        pause = Bitmap.createScaledBitmap(pause, length, height, false);

        // set the buttons
        pauseButton.rect = new Rect(pauseRect);
        pauseButton.action = Result.Pause;

        buttons.addElement(pauseButton);
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(pause, pauseButtonLoc.x, pauseButtonLoc.y, paint);
    }

    // getter
    public Vector getButtons() {
        return buttons;
    }
}
