/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
public class SimulatorEvent extends Event {
	public static final int STOP_EVENT = 0;
	
	SimulatorEvent(double delay, EventHandler handler, int EventType) {
		super(delay,handler,EventType);
	}
}
