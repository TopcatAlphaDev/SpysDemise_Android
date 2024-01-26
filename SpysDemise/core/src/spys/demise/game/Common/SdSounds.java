package spys.demise.game.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Kurt on 3/05/2016.
 */
public class SdSounds {

    private final Sound LevelEndSound;
    private Music BackgroundMusic;
    private final spys.demise.game.Levels.SdLevel Level;

    public SdSounds(spys.demise.game.Levels.SdLevel currentLevel) {
        Level = currentLevel;
        LevelEndSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdTadaa.mp3"));
    }

    public void SetBackgroundMusic(boolean PlaySound) {
        if (PlaySound) {
            if (BackgroundMusic == null) {
                BackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal(Level.GetBackgroundMusicFile()));
                BackgroundMusic.setLooping(true);
                BackgroundMusic.play();
            }
        } else {
            if (BackgroundMusic != null) {
                BackgroundMusic.stop();
                BackgroundMusic.dispose();
                BackgroundMusic = null;
            }
        }
    }

    public void Close()
    {
        SetBackgroundMusic(false);
        LevelEndSound.dispose();
    }

    public void LevelIsFinished() {
        LevelEndSound.play();
    }
}
