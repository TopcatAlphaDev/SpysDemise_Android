package spys.demise.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import spys.demise.game.*;
import spys.demise.game.Listeners.SdSpyTouchListener;

public class SdScreenMenu implements Screen {

    private final SdSpyTouchListener SpyTouchListener;

    final SpysDemise game;
    OrthographicCamera camera;
    private final BitmapFont Font;
    private final BitmapFont SmallFont;
    private final Sprite backgroundSprite;
    private final Texture SpyTexture;

    public SdScreenMenu(final SpysDemise gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        spys.demise.game.Common.SdFont oldTypeWriterFont = new spys.demise.game.Common.SdFont(96);
        Font = oldTypeWriterFont.GetFont();
        oldTypeWriterFont = new spys.demise.game.Common.SdFont(32);
        SmallFont = oldTypeWriterFont.GetFont();
        backgroundSprite = new Sprite(new Texture("Screens/SdHall.png"));
        backgroundSprite.setSize(800,480);
        SpyTexture = new Texture(Gdx.files.internal("Spy/SdSpyMain.png"));

        SpyTouchListener = new SdSpyTouchListener();
        Gdx.input.setInputProcessor(new GestureDetector(SpyTouchListener));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        backgroundSprite.draw(game.batch);
        game.batch.draw(SpyTexture, 430, 0);
        Font.setColor(Color.WHITE);
        Font.draw(game.batch, "Spy's", 30, 250);
        Font.setColor(Color.WHITE);
        Font.draw(game.batch, "Demise", 60, 140);
        SmallFont.setColor(Color.YELLOW);
        SmallFont.draw(game.batch, "By Topcat's world", 75, 40);

        game.batch.end();

        if (SpyTouchListener.IsScreenTouched()) {
            game.setScreen(new SdScreenGame(game));
            dispose();
        }
    }
    @Override
    public void dispose() {
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
