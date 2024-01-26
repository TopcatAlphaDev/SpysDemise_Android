package spys.demise.game.Listeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.input.GestureDetector.*;

/**
 * Created by Kurt on 4/10/2016.
 */
public class SdGameListener implements GestureListener {

    private boolean PressedLeft = false;
    private boolean PressedRight = false;

    public void Reset()
    {
        PressedLeft = false;
        PressedRight = false;
    }

    public boolean GetIsTouched()
    {
        return PressedLeft || PressedRight;
    }

    public boolean GetPressedLeft()
    {
        boolean _PressedLeft = PressedLeft;
        PressedLeft = false;
        return _PressedLeft;
    }

    public boolean GetPressedRight()
    {
        boolean _PressedRight = PressedRight;
        PressedRight = false;
        return _PressedRight;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        if (x < 320)
            PressedLeft = true;
        if (x > 320)
            PressedRight = true;
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
}
