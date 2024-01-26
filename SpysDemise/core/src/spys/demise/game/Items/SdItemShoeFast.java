package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemShoeFast extends SdItem {

    private final int TakeShoePoints = 5;

    public SdItemShoeFast(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        GameItemImage = new Texture(Gdx.files.internal("Items/SdShoeYellow.png"));
    }

    public boolean Overlap()
    {
        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.setLeftSpeed(-200);
            spy.setRightSpeed(200);
            spy.AddPoints(TakeShoePoints);
            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

}
