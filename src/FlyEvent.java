
public class FlyEvent extends Event{
	public static final int changeDirection = 1;
	public static final int flyIntoTrap = 2;
	
	FlyEvent(double delay, EventHandler handler, int EventType) {
		super(delay,handler,EventType);
	}

}
