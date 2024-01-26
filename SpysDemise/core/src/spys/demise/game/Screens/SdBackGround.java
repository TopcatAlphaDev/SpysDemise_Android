package spys.demise.game.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Kurt on 25/04/2016.
 */
public class SdBackGround {

    // Background image
    //private Texture backgroundTexture;
    //private Sprite backgroundSprite;

    private final int FloorLeftWidth = 10;
    private final int FloorRightWidth = 630;

    private final ShapeRenderer shapeRenderer;
    private final SpriteBatch backgroundBatch;
    private final Sprite backgroundSprite;

    public SdBackGround(spys.demise.game.Levels.SdLevel Level)
    {
        shapeRenderer = new ShapeRenderer();
        backgroundBatch = new SpriteBatch();
        backgroundSprite = new Sprite(new Texture(Level.GetBackgroundImageFile()));
        backgroundSprite.setSize(800,480);

    }

    public void Draw(OrthographicCamera camera) {

        backgroundBatch.setProjectionMatrix(camera.combined);
        backgroundBatch.begin();
        backgroundSprite.draw(backgroundBatch);
        backgroundBatch.end();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.BLUE);
        //shapeRenderer.rect(1, 1, 100, 100);
        //shapeRenderer.circle(100, 100, 50);
        shapeRenderer.rectLine(5, 5, 5, 475, 4);
        shapeRenderer.rectLine(3, 475, 637, 475, 4);
        shapeRenderer.rectLine(635, 475, 635, 5, 4);

        //shapeRenderer.setColor(Color.ORANGE);
        //shapeRenderer.rectLine(FloorLeftWidth, 433, FloorRightWidth, 433, 4);

        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rectLine(FloorLeftWidth, 427, FloorRightWidth, 427, 4);

        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.rectLine(FloorLeftWidth, 381, FloorRightWidth, 381, 4);
        DrawLadder(384,FloorRightWidth-25);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rectLine(FloorLeftWidth, 335, FloorRightWidth, 335, 4);
        DrawLadder(338,FloorLeftWidth+5);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rectLine(FloorLeftWidth, 289, FloorRightWidth, 289, 4);
        DrawLadder(292,FloorRightWidth-25);

        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rectLine(FloorLeftWidth, 243, FloorRightWidth, 243, 4);
        DrawLadder(246,FloorLeftWidth+5);

        shapeRenderer.setColor(Color.ORANGE);
        shapeRenderer.rectLine(FloorLeftWidth, 197, FloorRightWidth, 197, 4);
        DrawLadder(200,FloorRightWidth-25);

        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rectLine(FloorLeftWidth, 151, FloorRightWidth, 151, 4);
        DrawLadder(154,FloorLeftWidth+5);

        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.rectLine(FloorLeftWidth, 105, FloorRightWidth, 105, 4);
        DrawLadder(108,FloorRightWidth-25);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rectLine(FloorLeftWidth, 59, FloorRightWidth, 59, 4);
        DrawLadder(62,FloorLeftWidth+5);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rectLine(FloorLeftWidth, 13, FloorRightWidth, 13, 4);
        DrawLadder(16,FloorRightWidth-25);
        shapeRenderer.end();

    }
    private void DrawLadder(int VerticalPosition, int HorizontalPosition)
    {
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rectLine(HorizontalPosition, VerticalPosition, HorizontalPosition, VerticalPosition + 40, 2);
        shapeRenderer.rectLine(HorizontalPosition + 20, VerticalPosition, HorizontalPosition + 20, VerticalPosition + 40, 2);
        shapeRenderer.rectLine(HorizontalPosition, VerticalPosition + 8, HorizontalPosition + 20, VerticalPosition + 8, 2);
        shapeRenderer.rectLine(HorizontalPosition, VerticalPosition + 16, HorizontalPosition + 20, VerticalPosition + 16, 2);
        shapeRenderer.rectLine(HorizontalPosition, VerticalPosition + 24, HorizontalPosition + 20, VerticalPosition + 24, 2);
        shapeRenderer.rectLine(HorizontalPosition, VerticalPosition + 32, HorizontalPosition + 20, VerticalPosition + 32, 2);
    }
    public void close() {
        shapeRenderer.dispose();
        backgroundBatch.dispose();
    }
}
