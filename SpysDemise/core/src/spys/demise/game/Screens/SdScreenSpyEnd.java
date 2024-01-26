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

public class SdScreenSpyEnd implements Screen {

    private final SdSpyTouchListener SpyTouchListener;

    final SpysDemise game;
    OrthographicCamera camera;
    private final Sprite backgroundSprite;
    private final Music SpyDiedMusic;

    private final BitmapFont Font;
    private final int Score;
    public SdScreenSpyEnd(final SpysDemise _game, int _Score, BitmapFont NewFont) {
        Font = NewFont;
        Score = _Score;
        game = _game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        backgroundSprite = new Sprite(new Texture("Screens/SdRip.png"));
        backgroundSprite.setSize(800,480);

        SpyDiedMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/SdToccatFugue.mp3"));
        SpyDiedMusic.setLooping(true);

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
        Font.setColor(Color.ORANGE);
        Font.draw(game.batch, String.format("SCORE %05d", Score), 65, 45);

        game.batch.end();

        if (SpyTouchListener.IsScreenTouched()) {
            game.setScreen(new SdScreenMenu(game));
            dispose();
        }
    }

    @Override
    public void dispose() {
        SpyDiedMusic.dispose();
    }

    @Override
    public void show() {
        SpyDiedMusic.play();
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
        SpyDiedMusic.pause();
    }
}
