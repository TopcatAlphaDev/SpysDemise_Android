package spys.demise.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import spys.demise.game.Levels.SdLevel1;
import spys.demise.game.Elevators.SdElevators;
import spys.demise.game.Common.SdFont;
import spys.demise.game.Common.SdSounds;
import spys.demise.game.Listeners.SdGameListener;
import spys.demise.game.Spy.SdSpy;
import spys.demise.game.SpysDemise;

public class SdScreenGame implements Screen {

    private SdGameListener GameListener;

    final SpysDemise game;

	private SdSounds sounds;
	private SdElevators elevators;
    private SdSpy spy;
	private SdScoreBoard scoreBoard;
    private SdBackGround background;

    private spys.demise.game.Levels.SdLevel currentLevel;
    private spys.demise.game.Items.SdItems gameItems;

    private final SpriteBatch spriteBatch;
	private final OrthographicCamera camera;

    public SdScreenGame(final SpysDemise gam) {
        this.game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        spriteBatch = new SpriteBatch();

        SdFont oldTypeWriterFont = new SdFont(32);
        scoreBoard = new SdScoreBoard();
        scoreBoard.SetFont(oldTypeWriterFont.GetFont());
        currentLevel = new spys.demise.game.Levels.SdLevel1();
        InitializeGamePlay(currentLevel);
	}

    private void InitializeGamePlay(spys.demise.game.Levels.SdLevel currentLevel) {
        if (background != null) {
            background.close();
            background = null;
        }
        background = new SdBackGround(currentLevel);

        if (sounds != null) {
            sounds.Close();
            sounds = null;
        }
        sounds = new SdSounds(currentLevel);
        sounds.SetBackgroundMusic(true);

        spy = null;
        spy = new SdSpy(currentLevel);
        spy.CreateSpyAnimation();

        elevators = null;
        elevators = new SdElevators(currentLevel);
        elevators.CreateElevators(spy);
        elevators.setPauze(true);

        gameItems = null;
        gameItems = new spys.demise.game.Items.SdItems(currentLevel);
        gameItems.createGameItems(spy);
        scoreBoard.SetLevelNbr(currentLevel.GetLevelNbr());
        scoreBoard.SetLevelStartText(currentLevel.GetLevelStartText());

        CreateInputProcessor();
        }

    @Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        background.Draw(camera);

        //spriteBatch.enableBlending(); better performance
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spy.Draw(spriteBatch,Gdx.graphics.getDeltaTime());
        gameItems.Draw(spriteBatch);
        scoreBoard.AddToScore(spy.GetPoints());
        scoreBoard.Lives += spy.getExtraLives();
        scoreBoard.Draw(spriteBatch);
        elevators.Draw(spriteBatch);
		spriteBatch.end();

        ProcessInputs();

		elevators.Move(Gdx.graphics.getDeltaTime());
		if (elevators.OverlapDetected) {
            SpyIsHit();
		}

        if (currentLevel.IsFinished) {
            sounds.LevelIsFinished();
            if (currentLevel.IsFinalLevel()) {
                SdFont oldTypeWriterFont = new SdFont(32);
                SdScreenGameEnd GameEnd = new SdScreenGameEnd(game, scoreBoard.Score,oldTypeWriterFont.GetFont() );
                game.setScreen(GameEnd);
                this.dispose();
            } else {
                spys.demise.game.Levels.SdLevel nextLevel = currentLevel.GetNextLevel();
                InitializeGamePlay(nextLevel);
                currentLevel = nextLevel;
            }
        }
	}

    private void ProcessInputs() {
        if(GameListener.GetIsTouched()) {
            if (scoreBoard.Lives != 0) {
                if (elevators.getPauze()){
                    elevators.setPauze(false);
                    scoreBoard.SetLevelStartText("");
                }
                if (spy.Pauze) {
                    spy.Pauze = false;
                }
                if (GameListener.GetPressedLeft())
                    spy.ChangeDirectionToLeft();
                if (GameListener.GetPressedRight())
                    spy.ChangeDirectionToRight();
            }
        }
    }

    public void Reset()
    {
        GameListener.Reset();
        currentLevel = new SdLevel1();
        scoreBoard.SetLevelNbr(currentLevel.GetLevelNbr());
        scoreBoard.Lives = 3;
        scoreBoard.Score = 0;
        InitializeGamePlay(currentLevel);
        game.setScreen(this);
    }

    private void SpyIsHit()
    {
        scoreBoard.Lives--;
        spy.Pauze = true;
        spy.Reset();
        if (scoreBoard.Lives <= 0) {
            SdFont oldTypeWriterFont = new SdFont(16);
            SdScreenSpyEnd SpyEnd = new SdScreenSpyEnd(game, scoreBoard.Score,oldTypeWriterFont.GetFont() );
            game.setScreen(SpyEnd);
            this.dispose();
        } else {
            SdScreenSpyDied SpyDied = new SdScreenSpyDied(game, this);
            game.setScreen(SpyDied);
        }
    }

    @Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
        sounds.SetBackgroundMusic(true);
    }

	@Override
	public void hide() {
        sounds.SetBackgroundMusic(false);
    }

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
        spriteBatch.dispose();
        scoreBoard = null;
        background.close();
        background = null;
        spy.close();
        spy = null;
        elevators = null;
        sounds.Close();
        sounds = null;
        gameItems = null;
	}

    public void CreateInputProcessor() {
        GameListener = new SdGameListener();
        Gdx.input.setInputProcessor(new GestureDetector(GameListener));
    }
}
