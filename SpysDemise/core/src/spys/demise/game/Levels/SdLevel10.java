package spys.demise.game.Levels;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Kurt on 5/05/2016.
 */
public class SdLevel10 extends SdLevel {

    public SdLevel10() {

    }

    @Override
    public Array<spys.demise.game.Elevators.SdElevatorParameters> GetElevatorParameters() {
        Array<spys.demise.game.Elevators.SdElevatorParameters> Parameters = new Array<spys.demise.game.Elevators.SdElevatorParameters>();
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
        return 10;
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
        return new SdLevel11();
    }

    public Array<spys.demise.game.Items.SdItemParameters> GetGameItemParameters() {
        Array<spys.demise.game.Items.SdItemParameters> Parameters = new Array<spys.demise.game.Items.SdItemParameters>();
        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition1, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition1, spys.demise.game.Items.SdItemShoeFast.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition2, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition3, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition4, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition5, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition5, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition5, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition5, spys.demise.game.Items.SdItemHeart.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition5, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition5, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition5, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition6, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition7, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition8, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition9, spys.demise.game.Items.SdItemMoney.class));

        Parameters.add(new spys.demise.game.Items.SdItemParameters(539,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(457,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(375,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(293,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(211,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(129,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));
        Parameters.add(new spys.demise.game.Items.SdItemParameters(47,FloorYPosition10, spys.demise.game.Items.SdItemMoney.class));

        return Parameters;
    }

    @Override
    public String GetLevelStartText() {
        return "Bonus for the brave.";
    }

}
