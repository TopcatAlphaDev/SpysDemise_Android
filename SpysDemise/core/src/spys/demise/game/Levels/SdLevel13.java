package spys.demise.game.Levels;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Kurt on 5/05/2016.
 */
public class SdLevel13 extends SdLevel {

    public SdLevel13() {

    }

    @Override
    public Array<spys.demise.game.Elevators.SdElevatorParameters> GetElevatorParameters() {
        Array<spys.demise.game.Elevators.SdElevatorParameters> Parameters = new Array<spys.demise.game.Elevators.SdElevatorParameters>();
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(47,428,90,90));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(129,390,110,110));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(293,280,100,100));
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
        return 13;
    }

    @Override
    public String GetBackgroundMusicFile() {
        return "Music/SdHungarianDance.mp3";
    }

    @Override
    public String GetBackgroundImageFile() {
        return  "Screens/SdBackground1.jpg";
    }

    @Override
    public SdLevel GetNextLevel() {
        return new SdLevel14();
    }

    public Array<spys.demise.game.Items.SdItemParameters> GetGameItemParameters() {
        Array<spys.demise.game.Items.SdItemParameters> Parameters = new Array<spys.demise.game.Items.SdItemParameters>();
        Parameters.add(new spys.demise.game.Items.SdItemParameters(324,FloorYPosition1, spys.demise.game.Items.SdItemArrowUp.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(50,FloorYPosition2, spys.demise.game.Items.SdItemArrowDown.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(143,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(250,FloorYPosition2, spys.demise.game.Items.SdItemArrowDown.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(400,FloorYPosition4, spys.demise.game.Items.SdItemArrowUp.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(500,FloorYPosition5, spys.demise.game.Items.SdItemArrowUp.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(400,FloorYPosition6, spys.demise.game.Items.SdItemArrowUp.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(100,FloorYPosition8, spys.demise.game.Items.SdItemArrowDown.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(200,FloorYPosition7, spys.demise.game.Items.SdItemArrowDown.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(100,FloorYPosition6, spys.demise.game.Items.SdItemArrowDown.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(300,FloorYPosition6, spys.demise.game.Items.SdItemHeart.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        return Parameters;
    }
    @Override
    public String GetLevelStartText() {
        return "The thirteenth floor.";
    }

}
