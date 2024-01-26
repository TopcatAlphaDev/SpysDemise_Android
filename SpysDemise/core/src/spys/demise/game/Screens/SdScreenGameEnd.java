package spys.demise.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;

import spys.demise.game.Listeners.SdSpyTouchListener;
import spys.demise.game.SpysDemise;

public class SdScreenGameEnd implements Screen {

    private final SdSpyTouchListener SpyTouchListener;

    final SpysDemise game;
    OrthographicCamera camera;
    private final Sprite backgroundSprite;
    private final Music GameEndMusic;

    private final BitmapFont Font;
    private final int Score;
    public SdScreenGameEnd(final SpysDemise _game, int _Score, BitmapFont NewFont) {
        Font = NewFont;
        Score = _Score;
        game = _game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        backgroundSprite = new Sprite(new Texture("Screens/SdGameEnd.png"));
        backgroundSprite.setSize(800,480);

        GameEndMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/SdSouvenir.mp3"));
        GameEndMusic.setLooping(true);

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

        Font.setColor(Color.BLACK);
        Font.draw(game.batch, String.format("SCORE %05d  ( Thx for playing ! )", Score), 75, 440);

        game.batch.end();

        if (SpyTouchListener.IsScreenTouched()) {
            game.setScreen(new SdScreenMenu(game));
            dispose();
        }
    }

    @Override
    public void dispose() {
        GameEndMusic.dispose();
    }

    @Override
    public void show() {
        GameEndMusic.play();
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
        GameEndMusic.pause();
    }
}
