package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemTeleport extends SdItem {

    private final int TeleportPoints = 10;

    private final Random RandomNumber = new Random();

    public SdItemTeleport(int _HorizontalPosition, int _VerticalPosition, spys.demise.game.Spy.SdSpy _spy) {
        super(_HorizontalPosition, _VerticalPosition, _spy);
        GameItemImage = new Texture(Gdx.files.internal("Items/SdTeleport.png"));
    }

    protected void SetSound() {
        GameItemSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdTeleport.mp3"));
    }

    public boolean Overlap()
    {
        boolean OverlapDetected = super.Overlap();
        if (OverlapDetected) {
            spy.AddPoints(TeleportPoints);

            int RandomFloor = RandomNumber.nextInt(2);
            if (RandomFloor == 1) {
                spy.PreviousFloor();
            } else {
                spy.NextFloor();
            }
            int RandomPosition = RandomNumber.nextInt(595-15) + 15;
            spy.SetHorizontalPosition(RandomPosition);

            int RandomDirection = RandomNumber.nextInt(2);
            if (RandomDirection == 1) {
                spy.ChangeDirection();
            }

            itemJobIsDone = true;
        }
        return OverlapDetected;
    }

}
