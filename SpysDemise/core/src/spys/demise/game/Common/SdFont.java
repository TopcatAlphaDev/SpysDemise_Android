package spys.demise.game.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Kurt on 3/05/2016.
 */
public class SdFont {

    private BitmapFont Font;
    public SdFont(int Size) {
        CreateFont(Size);
    }

    private void CreateFont(int Size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/rusty_typewriter.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Size;
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?-";
        parameter.color = Color.WHITE;
        Font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();
    }

    public BitmapFont GetFont() {
        return Font;
    }

}
