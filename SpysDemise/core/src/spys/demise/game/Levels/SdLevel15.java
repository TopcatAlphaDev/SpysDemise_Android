package spys.demise.game.Levels;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Kurt on 5/05/2016.
 */
public class SdLevel15 extends SdLevel {

    public SdLevel15() {

    }

    @Override
    public Array<spys.demise.game.Elevators.SdElevatorParameters> GetElevatorParameters() {
        Array<spys.demise.game.Elevators.SdElevatorParameters> Parameters = new Array<spys.demise.game.Elevators.SdElevatorParameters>();
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(47,428,90,90));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(129,390,110,110));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(211,410,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(293,280,120,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(375,410,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(457,320,100,100));
        Parameters.add(new spys.demise.game.Elevators.SdElevatorParameters(539,120,80,90));
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
        return 15;
    }

    @Override
    public String GetBackgroundMusicFile() {
        return "Music/SdNapoletana.mp3";
    }

    @Override
    public String GetBackgroundImageFile() {
        return  "Screens/SdBackground3.jpg";
    }

    @Override
    public SdLevel GetNextLevel() {
        return new SdLevel16();
    }

    public Array<spys.demise.game.Items.SdItemParameters> GetGameItemParameters() {
        Array<spys.demise.game.Items.SdItemParameters> Parameters = new Array<spys.demise.game.Items.SdItemParameters>();
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition1, spys.demise.game.Items.SdItemKey.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(324,FloorYPosition2, spys.demise.game.Items.SdItemShoeSlow.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(484,FloorYPosition2, spys.demise.game.Items.SdItemCape.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(GetRandomPosition(),FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(224,FloorYPosition4, spys.demise.game.Items.SdItemArrowUp.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(324,FloorYPosition6, spys.demise.game.Items.SdItemShoeFast.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(444,FloorYPosition8, spys.demise.game.Items.SdItemArrowDown.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(44,FloorYPosition8, spys.demise.game.Items.SdItemDocument.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(550,FloorYPosition10, spys.demise.game.Items.SdItemShoeSlow.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(104,FloorYPosition10, spys.demise.game.Items.SdItemHeart.class));
        return Parameters;
    }

    @Override
    public String GetLevelStartText() {
        return "I didn't expect you here.";
    }

}
