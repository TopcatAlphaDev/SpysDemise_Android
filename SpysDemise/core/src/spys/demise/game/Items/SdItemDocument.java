package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemDocument extends SdItem {

    private final int CoinPoints = 2;
    private final int LevelUpPoints = 2;

    public SdItemDocument(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        active = false;
        GameItemImage = new Texture(Gdx.files.internal("Items/SdDocument.png"));
    }
    protected void SetSound() {
        GameItemSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdDocument.mp3"));
    }

    @Override
    public boolean Overlap()
    {
        CheckIfSpyPassed();

        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(CoinPoints);
            spy.SetLevelUpPoints(LevelUpPoints);
            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

    private void CheckIfSpyPassed() {
        if (!active && (spy.GetRectangle().getY() > GameItemRectangle.getY() - 5) && ((spy.GetRectangle().getX() > GameItemRectangle.getX()+50))) {
            active = true;
        }
    }

}
