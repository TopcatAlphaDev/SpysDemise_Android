package spys.demise.game.Items;

/**
 * Created by Kurt on 9/05/2016.
 */
public class SdItemParameters {

    public int XPosition;
    public int YPosition;
    public Class<? extends SdItem> GameItemType;

    public SdItemParameters(int _XPosition, int _YPosition, Class<? extends SdItem> _GameItemType) {
        XPosition = _XPosition;
        YPosition = _YPosition;
        GameItemType = _GameItemType;
    }

}
