package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemPhone extends SdItem {

    private final int PhonePoints = 15;
    private final int LevelUpPoints = 4;

    public SdItemPhone(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        active = false;
        GameItemImage = new Texture(Gdx.files.internal("Items/SdPhone.png"));
    }

    protected void SetSound() {
        GameItemSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdPhone.mp3"));
    }

    public boolean Overlap()
    {
        CheckIfSpyPassed();

        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(PhonePoints);
            spy.SetLevelUpPoints(LevelUpPoints);
            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

    private void CheckIfSpyPassed() {
        if (!active && (spy.GetRectangle().getY() > GameItemRectangle.getY() - 5) && ((spy.GetRectangle().getX() < GameItemRectangle.getX()-100))) {
            active = true;
        }
    }

}
