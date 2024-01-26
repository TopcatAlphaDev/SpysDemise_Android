package spys.demise.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import spys.demise.game.Spy.SdSpy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItem {

    protected Rectangle GameItemRectangle;
    protected Texture GameItemImage;
    protected SdSpy spy;
    protected boolean itemJobIsDone = false;
    protected boolean active = true;
    protected Sound GameItemSound;

    public SdItem(int _HorizontalPosition, int _VerticalPosition, SdSpy _spy) {
        GameItemRectangle = new Rectangle();
        GameItemRectangle.x = _HorizontalPosition;
        GameItemRectangle.y = _VerticalPosition;
        GameItemRectangle.width = 32;
        GameItemRectangle.height = 32;
        spy = _spy;
        SetSound();
    }

    protected void SetSound() {
        GameItemSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdGameItemHit.mp3"));
    }

    public void close()
    {
        GameItemSound.dispose();
    }

    public static SdItem CreateGameItem(Class<? extends SdItem> GameItemType, int _HorizontalPosition, int _VerticalPosition, SdSpy _spy)
    {
        SdItem eGameItem = null;
        Constructor constr = null;
        try {
            constr = GameItemType.getConstructor(new Class<?>[] { int.class, int.class, SdSpy.class});
            try {
                eGameItem = (SdItem) constr.newInstance( _HorizontalPosition, _VerticalPosition, _spy);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException nsme) {
            //handle constructor not being found
        }
        return eGameItem;
    }

    public void Draw(SpriteBatch batch) {
        if (active) {
            batch.draw(GameItemImage, GameItemRectangle.x, GameItemRectangle.y);
        }
    }

    public boolean Overlap()
    {
        if (active) {
            boolean GameItemHit = GameItemRectangle.overlaps(spy.GetRectangle());
            if (GameItemHit) {GameItemSound.play();}
            return GameItemHit;
        } else {
            return false;
        }
    }

    public boolean JobIsDone()
    {
        if (itemJobIsDone) {GameItemSound.dispose();}
        return itemJobIsDone;
    }
}
