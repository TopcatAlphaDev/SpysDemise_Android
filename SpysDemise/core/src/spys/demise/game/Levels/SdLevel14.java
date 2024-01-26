package spys.demise.game.Levels;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Kurt on 5/05/2016.
 */
public class SdLevel14 extends SdLevel {

    public SdLevel14() {

    }

    @Override
    public Array<spys.demise.game.Elevators.SdElevatorParameters> GetElevatorParameters() {
        Array<spys.demise.game.Elevators.SdElevatorParameters> Parameters = new Array<spys.demise.game.Elevators.SdElevatorParameters>();
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(47,428,90,90));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(129,390,110,110));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(211,410,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(293,280,120,105));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(375,410,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(457,320,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(539,120,80,80));
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
        return 14;
    }

    @Override
    public String GetBackgroundMusicFile() {
        return "Music/SdChopSticks.mp3";
    }

    @Override
    public String GetBackgroundImageFile() {
        return  "Screens/SdBackground2.jpg";
    }

    @Override
    public SdLevel GetNextLevel() {
        return new SdLevel15();
    }

    public Array<spys.demise.game.Items.SdItemParameters> GetGameItemParameters() {
        Array<spys.demise.game.Items.SdItemParameters> Parameters = new Array<spys.demise.game.Items.SdItemParameters>();
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition2, spys.demise.game.Items.SdItemPhone.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(50,FloorYPosition2, spys.demise.game.Items.SdItemCape.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(324,FloorYPosition4, spys.demise.game.Items.SdItemShoeFast.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition7, spys.demise.game.Items.SdItemCamera.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(324,FloorYPosition8, spys.demise.game.Items.SdItemArrowUp.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition10, spys.demise.game.Items.SdItemHeart.class));
        return Parameters;
    }
    @Override
    public String GetLevelStartText() {
        return "Can you dig it?";
    }

}
