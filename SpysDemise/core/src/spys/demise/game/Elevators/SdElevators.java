package spys.demise.game.Elevators;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by Kurt on 3/05/2016.
 */
public class SdElevators extends com.badlogic.gdx.utils.Array<spys.demise.game.Elevators.SdElevator> {


    private Array<spys.demise.game.Elevators.SdElevator> Elevators;
    private Rectangle RectangleForOverlap;

    public boolean OverlapDetected;

    private boolean Pauze = false;

    private final spys.demise.game.Levels.SdLevel Level;

    public boolean isPauze() {
        return Pauze;
    }

    public void setPauze(boolean pauze) {
        Pauze = pauze;
        for(spys.demise.game.Elevators.SdElevator Elevator: Elevators) {
            Elevator.Pauze = Pauze;
        }
    }

    public SdElevators(spys.demise.game.Levels.SdLevel CurrentLevel) {
        Level = CurrentLevel;
    }

    public void Draw(SpriteBatch batch) {
        for(spys.demise.game.Elevators.SdElevator Elevator: Elevators) {
            Elevator.Draw(batch);
        }
    }

    public void CreateElevators(spys.demise.game.Spy.SdSpy spy) {
        Elevators = new Array<spys.demise.game.Elevators.SdElevator>();
        Array<SdElevatorParameters> Parameters = Level.GetElevatorParameters();
        Iterator<SdElevatorParameters> iter = Parameters.iterator();
        while(iter.hasNext()) {
            SdElevatorParameters Param = iter.next();
            SpawnElevator(Param.XPosition,Param.YPosition,Param.UpSpeed,Param.DownSpeed, spy);
        }
    }

    private void SpawnElevator(int HorizontalPosition, int VerticalPosition, int upSpeed, int downSpeed, spys.demise.game.Spy.SdSpy spy) {
        spys.demise.game.Elevators.SdElevator MyElevator = new spys.demise.game.Elevators.SdElevator(HorizontalPosition, VerticalPosition, spy);
        MyElevator.setUpSpeed(upSpeed);
        MyElevator.setDownSpeed(-downSpeed);

        Elevators.add(MyElevator);
    }

    public void Move(float DeltaTime) {
        OverlapDetected = false;
        Iterator<spys.demise.game.Elevators.SdElevator> iter = Elevators.iterator();
        while(iter.hasNext()) {
            spys.demise.game.Elevators.SdElevator Elevator = iter.next();
            Elevator.Move(DeltaTime);
            if (Elevator.Overlap()) {
                OverlapDetected = true;
            }
        }
    }

    public boolean getPauze() {
        return Pauze;
    }
}
