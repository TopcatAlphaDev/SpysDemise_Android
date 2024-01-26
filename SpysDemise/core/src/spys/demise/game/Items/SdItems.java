package spys.demise.game.Items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by Kurt on 3/05/2016.
 */
public class SdItems {

    private Array<spys.demise.game.Items.SdItem> GameItems;

    public boolean OverlapDetected;

    public boolean Pauze = false;

    private final spys.demise.game.Levels.SdLevel Level;

    public SdItems(spys.demise.game.Levels.SdLevel currentLevel) {
        Level = currentLevel;
    /*
    - Ray gun / pistol,
    - invisible cape
    - running shoes.
    * */
    }

    public void Draw(SpriteBatch batch)
    {
        OverlapDetected = false;
        for(spys.demise.game.Items.SdItem GameItem: GameItems) {
            GameItem.Draw(batch);
            if (GameItem.Overlap()) {
                OverlapDetected = true;
            }
        }
        for(spys.demise.game.Items.SdItem GameItem: GameItems) {
            if (GameItem.JobIsDone()) {
                GameItem.close();
                GameItems.removeValue(GameItem, false);
            }
        }

        //lastDropTime = TimeUtils.nanoTime();
        // MathUtils.random(0, 640 - 40);

        // Draw a custom line
        //shapeRenderer.setProjectionMatrix(camera.combined);
        //shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        //shapeRenderer.setColor(Color.WHITE);
        //shapeRenderer.line(1, 1, 480, 640);
        //shapeRenderer.rectLine(0, 0, 640, 480, 1);
        //shapeRenderer.rect(0, 0, 640, 480);
        //shapeRenderer.circle(x, y, radius);
        //shapeRenderer.end();


/*		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0.f, 0.f, 0.f, 1.f);
		shapeRenderer.identity();
		shapeRenderer.translate(20.f, 10.f, 0.f);
		shapeRenderer.rotate(0.f, 0.f, 1.f, 45.f);
		shapeRenderer.rect(10, 10, 200, 200);
		shapeRenderer.end();
*/
    }

    public void createGameItems(spys.demise.game.Spy.SdSpy spy) {
        GameItems = new Array<spys.demise.game.Items.SdItem>();
        Array<SdItemParameters> Parameters = Level.GetGameItemParameters();
        Iterator<SdItemParameters> iter = Parameters.iterator();
        while(iter.hasNext()) {
            SdItemParameters Param = iter.next();
            SpawnGameItem(Param.GameItemType, Param.XPosition,Param.YPosition, spy);
        }

    }

    private void SpawnGameItem(Class<? extends spys.demise.game.Items.SdItem> GameItemType, int xPosition, int yPosition, spys.demise.game.Spy.SdSpy spy) {
        spys.demise.game.Items.SdItem MyGameItem = spys.demise.game.Items.SdItem.CreateGameItem(GameItemType, xPosition, yPosition, spy);
        GameItems.add(MyGameItem);
    }
}
