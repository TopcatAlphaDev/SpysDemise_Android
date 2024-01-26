package spys.demise.game.Elevators;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import spys.demise.game.Spy.SdSpy;

/**
 * Created by Kurt on 26/04/2016.
 */
public class SdElevator {

    private final Texture elevatorSpyImage;
    private final Texture elevatorEmptyImage;
    private Texture elevatorImage;

    private int UpSpeed = 100;
    private int DownSpeed = -100;
    private final SdSpy spy;

    public Rectangle ElevatorRectangle;

    public int ElevatorDirectionStep;

    public boolean Pauze = false;

    public boolean HasSpy = true;

    public SdElevator(int _HorizontalPosition, int _VerticalPosition, SdSpy _spy)
    {
        elevatorSpyImage = new Texture(Gdx.files.internal("Spy/SdElevatorSpy.png"));
        elevatorEmptyImage = new Texture(Gdx.files.internal("Spy/SdElevatorEmpty.png"));
        setHasSpy(true);

        ElevatorRectangle = new Rectangle();
        ElevatorRectangle.x = _HorizontalPosition;
        ElevatorRectangle.y = _VerticalPosition;
        ElevatorRectangle.width = 40;
        ElevatorRectangle.height = 40;
        spy = _spy;
        ElevatorDirectionStep = DownSpeed;
    }
    public void setHasSpy(boolean _HasSpy)
    {
        HasSpy = _HasSpy;
        if (HasSpy) {
            elevatorImage = elevatorSpyImage;
        } else {
            elevatorImage = elevatorEmptyImage;
        }
    }
    public void setUpSpeed(int _UpSpeed)
    {
        if (ElevatorDirectionStep == UpSpeed)
            ElevatorDirectionStep = _UpSpeed;
        UpSpeed =  _UpSpeed;
    }

    public int getUpSpeed()
    {
        return UpSpeed;
    }

    public void setDownSpeed(int _DownSpeed)
    {
        if (ElevatorDirectionStep == DownSpeed)
            ElevatorDirectionStep = _DownSpeed;

        DownSpeed = _DownSpeed;
    }
    public int getDownSpeed()
    {
        return DownSpeed;
    }

    public Rectangle GetRectangle() {
        return ElevatorRectangle;
    }

    public void Draw(SpriteBatch batch)
    {
        batch.draw(elevatorImage, ElevatorRectangle.x, ElevatorRectangle.y);
    }

    public void Move(float DeltaTime)
    {
        if (!Pauze && !spy.IsElevatorSabotage()) {
            ElevatorRectangle.y += ElevatorDirectionStep * DeltaTime;
            if (ElevatorRectangle.y < 15) ElevatorDirectionStep = UpSpeed;
            if (ElevatorRectangle.y > 431) ElevatorDirectionStep = DownSpeed;
        }
    }

    public boolean Overlap()
    {
        if (spy.IsInVisible() || !HasSpy) {
            return false;
        } else {
            boolean _Overlap = ElevatorRectangle.overlaps(spy.GetRectangle());
            if (_Overlap && spy.GetHasGun()) {
                setHasSpy(false);
                return false;
            }
            return _Overlap;
        }
    }
}
