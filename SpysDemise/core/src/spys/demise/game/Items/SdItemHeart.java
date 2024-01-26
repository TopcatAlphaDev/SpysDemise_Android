package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemHeart extends SdItem {

    private final int HeartPoints = 2;

    public SdItemHeart(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        GameItemImage = new Texture(Gdx.files.internal("Items/SdHeart.png"));
    }

    public boolean Overlap()
    {
        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(HeartPoints);
            spy.setExtraLives(1);
            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

}
