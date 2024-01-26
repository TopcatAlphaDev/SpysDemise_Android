package spys.demise.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import spys.demise.game.Listeners.SdSpyTouchListener;
import spys.demise.game.SpysDemise;

public class SdScreenSpyDied implements Screen {

    private final SdSpyTouchListener SpyTouchListener;

    final SpysDemise game;
    OrthographicCamera camera;
    private final Sprite backgroundSprite;
    private final Texture SpyBlackTexture;
    private final Texture SpyTexture;

    private final Sound GunShotSound;

    private int xPosition = 801;
    private final int BlackSpyEndPosition = 430;
    private final SdScreenGame MainScreen;

    private boolean MusicHasPlayed = false;

    public SdScreenSpyDied(final SpysDemise _game, SdScreenGame _MainScreen) {
        game = _game;
        MainScreen = _MainScreen;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        GunShotSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdGunFire.mp3"));
        backgroundSprite = new Sprite(new Texture("Screens/SdHall.png"));
        backgroundSprite.setSize(800,480);
        SpyBlackTexture = new Texture(Gdx.files.internal("Spy/SdSpyBlack.png"));
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
        game.batch.draw(SpyTexture, 30, 0);
        if (xPosition > BlackSpyEndPosition) {
            xPosition -= Math.round(400 * Gdx.graphics.getDeltaTime());
            if (xPosition < BlackSpyEndPosition) {
                xPosition = BlackSpyEndPosition;
            }
            game.batch.draw(SpyBlackTexture, xPosition, 0);
            game.batch.end();
        } else {
            game.batch.draw(SpyBlackTexture, BlackSpyEndPosition, 0);
            game.batch.end();
            if (!MusicHasPlayed) {
                SpyIsHit();
            }
        }
        if (SpyTouchListener.IsScreenTouched() && MusicHasPlayed) {
            MainScreen.CreateInputProcessor();
            game.setScreen(MainScreen);
            dispose();
        }
    }

    public void SpyIsHit() {
        MusicHasPlayed = true;
        GunShotSound.play();
    }

    @Override
    public void dispose() {
        GunShotSound.dispose();
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
