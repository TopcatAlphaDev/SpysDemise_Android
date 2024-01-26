package spys.demise.game.Spy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Kurt on 30/04/2016.
 */
public class SdSpy {

    private Texture walkSheet;
    private TextureRegion[] walkFrames;

    private final int FRAME_COLS = 4;
    private final int FRAME_ROWS = 2;

    private TextureRegion currentFrame;
    private float stateTime;
    private float stateTimeInvisible;
    private float stateTimeElevator;

    private Animation walkAnimationRight;
    private Animation walkAnimationLeft;
    private Animation walkAnimationRightInvisible;
    private Animation walkAnimationLeftInvisible;
    private Animation SpyWalkAnimation;
    private float SpyDirectionStep;

    private float RightSpeed = 100;
    private float LeftSpeed = -100;

    private int floorOffset = 14;
    private int FloorNbr = 0;
    private int NbrOfFloors = 10;

    private final Rectangle SpyRectangle;
    private final spys.demise.game.Levels.SdLevel Level;
    private int RightPosition = 602;
    private int LeftPosition = 15;

    public boolean Pauze = true;
    private final float FrameRate = 0.0625f;

    private int Points;
    private int LevelUpPoints = 1;
    private int LevelFinishedPoints = 5;
    private int ExtraLives = 0;
    private boolean InVisible = false;
    private boolean HasGun = false;
    private float InVisibleTimerReference;

    private boolean ElevatorSabotage = false;
    private float ElevatorSabotageTimerReference;

    protected Sound ItemGunSound;

    public SdSpy(spys.demise.game.Levels.SdLevel currentLevel) {
        Level = currentLevel;
        SetParameters();
        stateTime = 0f;
        stateTimeInvisible = 0f;
        stateTimeElevator = 0f;
        SpyDirectionStep = RightSpeed;
        SpyRectangle = new Rectangle(LeftPosition, GetFloorPosition(),22,40);
        SetSound();
    }

    private void SetSound() {
        ItemGunSound = Gdx.audio.newSound(Gdx.files.internal("Music/SdGunFire.mp3"));
    }

    public Rectangle GetRectangle() {
        return SpyRectangle;
    }

    public void setRightSpeed(float _RightSpeed) {
        if (SpyDirectionStep == RightSpeed)
            SpyDirectionStep = _RightSpeed;
        RightSpeed = _RightSpeed;
        float animationDuration = Math.abs((float)(6.25 / RightSpeed));
        walkAnimationRight.setFrameDuration(animationDuration);
        walkAnimationRightInvisible.setFrameDuration(animationDuration);
    }

    public float getRightSpeed() {
        return RightSpeed;
    }

    public void setLeftSpeed(float _LeftSpeed) {
        if (SpyDirectionStep == LeftSpeed)
            SpyDirectionStep = _LeftSpeed;
        LeftSpeed = _LeftSpeed;
        float animationDuration = Math.abs((float)(6.25 / LeftSpeed));
        walkAnimationLeft.setFrameDuration(animationDuration);
        walkAnimationLeftInvisible.setFrameDuration(animationDuration);
    }

    public float getLeftSpeed() {
        return LeftSpeed;
    }

    public void CreateSpyAnimation() {
        walkAnimationRight = CreateAnimation("Spy/SdWalkRight.png");
        walkAnimationLeft = CreateAnimation("Spy/SdWalkLeft.png");
        walkAnimationRightInvisible = CreateAnimation("Spy/SdWalkRightInvisible.png");
        walkAnimationLeftInvisible = CreateAnimation("Spy/SdWalkLeftInvisible.png");
        SpyWalkAnimation = GetwalkAnimationRight();
    }

    private Animation GetwalkAnimationRight() {
        if (InVisible) {
            return walkAnimationRightInvisible;
        }
        else {
            return walkAnimationRight;
        }
    }

    private Animation GetwalkAnimationLeft() {
        if (InVisible) {
            return walkAnimationLeftInvisible;
        }
        else {
            return walkAnimationLeft;
        }
    }

    private void SetParameters() {
        SdSpyParameters Parameters = Level.GetSpyParameters();
        RightSpeed = Parameters.RightSpeed;
        LeftSpeed = Parameters.LeftSpeed;
        Pauze = Parameters.Pauze;
        floorOffset = Parameters.FloorOffset;
        FloorNbr = Parameters.FloorNbr;
        NbrOfFloors = Parameters.NbrOfFloors;
        RightPosition = Parameters.RightPosition;
        LeftPosition = Parameters.LeftPosition;
    }

    private Animation CreateAnimation(String FileName) {
        walkSheet = new Texture(Gdx.files.internal(FileName));
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        return new Animation(FrameRate, walkFrames);
    }

    public void SetHorizontalPosition(int HorizontalPosition)
    {
        SpyRectangle.x = HorizontalPosition;
    }

    public void Draw(SpriteBatch spriteBatch, float DeltaTime) {
        if (!Pauze) {
            SpyRectangle.x += Math.round(SpyDirectionStep * DeltaTime);
            stateTime += DeltaTime;
        }
        stateTimeInvisible += DeltaTime;
        stateTimeElevator += DeltaTime;
        if (InVisible && stateTimeInvisible > InVisibleTimerReference) {
            InVisible = false;
            SetInvisibleSuite();
        }

        if (ElevatorSabotage && stateTimeElevator > ElevatorSabotageTimerReference) {
            ElevatorSabotage = false;
        }

        SpyRectangle.y = GetFloorPosition();
        currentFrame = SpyWalkAnimation.getKeyFrame(stateTime, true);
        if (SpyRectangle.x > RightPosition) {
            SpyRectangle.x = RightPosition;
            SpyDirectionStep = LeftSpeed;
            SpyWalkAnimation = GetwalkAnimationLeft();
            Pauze = true;
            CheckFloorUpRight();
        }
        if (SpyRectangle.x < LeftPosition) {
            SpyRectangle.x = LeftPosition;
            SpyDirectionStep = RightSpeed;
            SpyWalkAnimation = GetwalkAnimationRight();
            Pauze = true;
            CheckFloorUpLeft();
        }
        spriteBatch.draw(currentFrame, (SpyRectangle.x - 5), SpyRectangle.y);
    }

    private void CheckFloorUpRight() {
        if ((FloorNbr % 2) == 0) { NextFloor(); }
    }

    private void CheckFloorUpLeft() {
        if ((FloorNbr % 2) != 0) { NextFloor(); }
    }

    public void NextFloor() {
        if ((FloorNbr + 1) < NbrOfFloors) {
            FloorNbr++;
            AddPoints(LevelUpPoints);
        } else {
            AddPoints(LevelFinishedPoints);
            Level.SetIsFinished(true);
        }
    }

    public void PreviousFloor() {
        if ((FloorNbr - 1) >= 0) {
            FloorNbr--;
        }
    }

    public void AddPoints(int _points) {
        Points += _points;
    }

    public void ChangeDirection() {
        if (SpyDirectionStep == LeftSpeed) {
            ChangeDirectionToRight();
        } else if (SpyDirectionStep == RightSpeed) {
            ChangeDirectionToLeft();
        }
    }

    public void ChangeDirectionToLeft() {
        SpyDirectionStep = LeftSpeed;
        SpyWalkAnimation = GetwalkAnimationLeft();
    }

    public void ChangeDirectionToRight() {
        SpyDirectionStep = RightSpeed;
        SpyWalkAnimation = GetwalkAnimationRight();
    }

    private int GetFloorPosition() {
        return floorOffset + (FloorNbr * 46);
    }

    public int GetFloorNbr() {
        return FloorNbr;
    }

    public boolean Overlap(Rectangle OtherObject) {
        return SpyRectangle.overlaps(OtherObject);
    }

    public void Reset() {
        if ((FloorNbr % 2) == 0) {
            SpyRectangle.x = LeftPosition;
        } else {
            SpyRectangle.x = RightPosition;
        }
        SdSpyParameters Parameters = Level.GetSpyParameters();
        setRightSpeed(Parameters.RightSpeed);
        setLeftSpeed(Parameters.LeftSpeed);
        LevelUpPoints = 1;
        LevelFinishedPoints = 5;
        InVisible = false;
        HasGun = false;
        ElevatorSabotage = false;
    }

    public int GetPoints() {
        int tmpPoints = Points;
        Points = 0;
        return tmpPoints;
    }

    public void SetLevelUpPoints(int Points) {
        LevelUpPoints = Points;
    }

    public void SetInVisible(int _seconds) {
        InVisible = true;
        InVisibleTimerReference = stateTimeInvisible + _seconds;
        SetInvisibleSuite();
    }

    public void SetElevatorSabotage(int _seconds){
        ElevatorSabotage = true;
        ElevatorSabotageTimerReference = stateTimeElevator + _seconds;
    }

    public void SetHasGun()
    {
        HasGun = true;
    }

    public boolean GetHasGun()
    {
        boolean tmpHasGun = HasGun;
        HasGun = false;
        if (tmpHasGun){
            ItemGunSound.play();
        }
        return tmpHasGun;
    }

    public boolean IsInVisible() {
        return InVisible;
    }
    public boolean IsElevatorSabotage() {
        return ElevatorSabotage;
    }
    private void SetInvisibleSuite() {
        if (SpyDirectionStep == RightSpeed) {
            SpyWalkAnimation = GetwalkAnimationRight();
        }
        if (SpyDirectionStep == LeftSpeed) {
            SpyWalkAnimation = GetwalkAnimationLeft();
        }
    }

    public int getExtraLives() {
        int Result = ExtraLives;
        ExtraLives = 0;
        return Result;
    }

    public void setExtraLives(int extraLives) {
        ExtraLives += extraLives;
    }

    public void close()
    {
        ItemGunSound.dispose();
    }

}
