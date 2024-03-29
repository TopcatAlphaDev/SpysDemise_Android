
package spys.demise.game.Listeners;

import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.input.GestureDetector.GestureListener;

/**
 * Created by Kurt on 4/10/2016.
 */
public class SdSpyTouchListener implements GestureListener {

    private boolean ScreenTouched = false;

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        ScreenTouched = true;
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    public boolean IsScreenTouched() {
        boolean TmpScreenTouched = ScreenTouched;
        ScreenTouched = false;
        return TmpScreenTouched;
    }
}
