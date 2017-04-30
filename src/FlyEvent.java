/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
public class FlyEvent extends Event{
	public static final int changeDirection = 1;
	public static final int knockIntoWall = 2;
	public static final int flyIntoTrap = 3;
	
	FlyEvent(double delay, EventHandler handler, int EventType) {
		super(delay,handler,EventType);
	}

}
