package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemElectricity extends SdItem {

    private final int ElectricityPoints = 10;

    public SdItemElectricity(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        GameItemImage = new Texture(Gdx.files.internal("Items/SdElectricity.png"));
    }
    protected void SetSound() {
        GameItemSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdElectricity.mp3"));
    }
    public boolean Overlap()
    {
        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(ElectricityPoints);
            itemJobIsDone = true;
            spy.SetElevatorSabotage (10);
        }
        return OverlapDetected;
    }

}
