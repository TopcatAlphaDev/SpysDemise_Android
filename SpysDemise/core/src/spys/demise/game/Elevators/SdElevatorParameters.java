package spys.demise.game.Elevators;

/**
 * Created by Kurt on 5/05/2016.
 */
public class SdElevatorParameters {
    public int XPosition = 0;
    public int YPosition = 0;
    public int UpSpeed = 0;
    public int DownSpeed = 0;

    public SdElevatorParameters(int XPosition, int YPosition, int upSpeed, int downSpeed) {
        this.XPosition = XPosition;
        this.YPosition = YPosition;
        this.UpSpeed = upSpeed;
        this.DownSpeed = downSpeed;
    }
}
