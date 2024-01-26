package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemMoney extends SdItem {

    private final int CoinPoints = 10;

    public SdItemMoney(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        GameItemImage = new Texture(Gdx.files.internal("Items/SdMoney.png"));
    }

    public boolean Overlap()
    {
        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(CoinPoints);
            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

}
