package spys.demise.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Kurt on 25/04/2016.
 */

public class SdScoreBoard {

    private final String HighScoreField = "HighScore";
    public int Score = 0;
    public int HighScore = 0;
    public int Lives = 3;
    public int LevelNbr = 1;
    public String LevelStartText = "";
    private final Preferences prefs;

    private BitmapFont Font;
    private spys.demise.game.Levels.SdLevel Level;

    public SdScoreBoard() {
        prefs = Gdx.app.getPreferences("SpysDemise");
        HighScore = prefs.getInteger(HighScoreField, 0);
    }

    public void Draw(SpriteBatch spriteBatch) {
        Font.setColor(Color.WHITE);
        Font.draw(spriteBatch, "SCORE", 660, 460);
        Font.draw(spriteBatch, "LEVEL", 660, 360);
        Font.draw(spriteBatch, "LIVES", 660, 260);
        Font.draw(spriteBatch, "HIGH-", 660, 160);
        Font.draw(spriteBatch, "SCORE", 660, 120);

        Font.setColor(Color.BLUE);
        Font.draw(spriteBatch, String.format("%05d", Score), 675, 410);
        Font.draw(spriteBatch, String.format("%02d", LevelNbr), 740, 310);
        Font.draw(spriteBatch, String.format("%01d", Lives), 760, 210);
        Font.draw(spriteBatch, String.format("%05d", HighScore), 675, 70);

        if (LevelStartText != "") {
            Font.setColor(Color.WHITE);
            int HorizontalPosition = 320 - (LevelStartText.length() * 9);
            Font.draw(spriteBatch, LevelStartText, HorizontalPosition, 280);
        }

    }

    public void AddToScore(int ScorePoints)
    {
        Score += ScorePoints;
        if (Score > HighScore)
        {
            HighScore = Score;
            prefs.putInteger(HighScoreField, HighScore);
            prefs.flush();
        }
    }

    public void SetFont(BitmapFont NewFont) {
        Font = NewFont;
    }

    public void SetLevelNbr(int levelNbr) {
        this.LevelNbr = levelNbr;
    }

    public void SetLevelStartText(String levelStartText) {
        this.LevelStartText = levelStartText;
    }

}
