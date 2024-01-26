package spys.demise.game.Levels;

import com.badlogic.gdx.utils.Array;
import spys.demise.game.Elevators.SdElevatorParameters;
import spys.demise.game.Items.SdItemParameters;
import spys.demise.game.Spy.SdSpyParameters;

import java.util.Random;

/**
 * Created by Kurt on 5/05/2016.
 */
public abstract class SdLevel {

    private final Random RandomNumber = new Random();

    public boolean IsFinished;

    protected int FloorYPosition1 = 18;
    protected int FloorYPosition2 = 64;
    protected int FloorYPosition3 = 110;
    protected int FloorYPosition4 = 156;
    protected int FloorYPosition5 = 202;
    protected int FloorYPosition6 = 248;
    protected int FloorYPosition7= 294;
    protected int FloorYPosition8 = 340;
    protected int FloorYPosition9 = 386;
    protected int FloorYPosition10 = 432;

    public abstract Array<SdElevatorParameters> GetElevatorParameters();

    public abstract SdSpyParameters GetSpyParameters();

    public abstract int GetLevelNbr();

    public boolean IsFinalLevel() {
        return false;
    }

    public abstract String GetBackgroundMusicFile();

    public abstract String GetBackgroundImageFile();

    public void SetIsFinished(boolean IsFinished) {
        this.IsFinished = IsFinished;
    }

    protected int GetRandomPosition()
    {
        return RandomNumber.nextInt(570-40) + 40;
    }

    public abstract SdLevel GetNextLevel();

    public abstract Array<SdItemParameters> GetGameItemParameters();

    public String GetLevelStartText() {
        return "Get ready...";
    }
}
