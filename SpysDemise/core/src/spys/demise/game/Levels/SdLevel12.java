package spys.demise.game.Levels;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Kurt on 5/05/2016.
 */
public class SdLevel12 extends SdLevel {

    public SdLevel12() {

    }

    @Override
    public Array<spys.demise.game.Elevators.SdElevatorParameters> GetElevatorParameters() {
        Array<spys.demise.game.Elevators.SdElevatorParameters> Parameters = new Array<spys.demise.game.Elevators.SdElevatorParameters>();
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(47,428,90,90));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(129,390,110,110));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(211,410,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(375,410,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(457,320,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(539,120,90,90));
        return Parameters;
    }

    @Override
    public spys.demise.game.Spy.SdSpyParameters GetSpyParameters() {
        spys.demise.game.Spy.SdSpyParameters Parameters = new spys.demise.game.Spy.SdSpyParameters();
        Parameters.RightSpeed = 100;
        Parameters.LeftSpeed = -100;
        Parameters.Pauze = true;
        Parameters.FloorOffset = 14;
        Parameters.FloorNbr = 0;
        Parameters.NbrOfFloors = 10;
        Parameters.RightPosition = 602;
        Parameters.LeftPosition = 15;
        return Parameters;
    }

    @Override
    public int GetLevelNbr() {
        return 12;
    }

    @Override
    public String GetBackgroundMusicFile() {
        return "Music/SdSouvenir.mp3";
    }

    @Override
    public String GetBackgroundImageFile() {
        return  "Screens/SdBackground4.jpg";
    }

    @Override
    public SdLevel GetNextLevel() {
        return new SdLevel13();
    }

    public Array<spys.demise.game.Items.SdItemParameters> GetGameItemParameters() {
        Array<spys.demise.game.Items.SdItemParameters> Parameters = new Array<spys.demise.game.Items.SdItemParameters>();
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition1, spys.demise.game.Items.SdItemCamera.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(54,FloorYPosition3, spys.demise.game.Items.SdItemDocument.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition5, spys.demise.game.Items.SdItemKey.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition6, spys.demise.game.Items.SdItemSecurityCam.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(350,FloorYPosition8, spys.demise.game.Items.SdItemShoeSlow.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        return Parameters;
    }
    @Override
    public String GetLevelStartText() {
        return "The heavy shoes.";
    }

}
