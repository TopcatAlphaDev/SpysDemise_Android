package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemArrowDown extends SdItem {

    private final int ArrowUpPoints = 10;

    public SdItemArrowDown(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        active = true;
        GameItemImage = new Texture(Gdx.files.internal("Items/SdArrowDown.png"));
    }

    protected void SetSound() {
        GameItemSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdZip.mp3"));
    }

    public boolean Overlap()
    {
        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(ArrowUpPoints);
            spy.PreviousFloor();
            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

}
