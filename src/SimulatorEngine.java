import java.util.TreeSet;

public class SimulatorEngine implements EventHandler{
	private double sim_currentTime;
	private boolean sim_running;
	private TreeSet<Event> sim_eventList;
	
	SimulatorEngine() {
		sim_running = false;
		sim_currentTime = 0;
		sim_eventList = new TreeSet<Event>();
	}
	
	void run() {
		sim_running = true;
		while(sim_running==true && !sim_eventList.isEmpty())
		{
			Event ev = sim_eventList.pollFirst();
			sim_currentTime = ev.getTime();
			ev.getHandler().handle(ev);	
		}
	}
	
	@Override
	public void handle(Event ev) {
		SimulatorEvent event = (SimulatorEvent)ev;
		switch(event.getType()) {
		case SimulatorEvent.STOP_EVENT:
			sim_running = false;
			System.out.println("Simulator stopping at time: " + ev.getTime());
			break;
		default:
			System.out.println("Unknown event type...");
				
		}
	}
	
    public void schedule(Event event) {
        sim_eventList.add(event);
    }

    public void stop() {
        sim_running = false;
    }

    public double getCurrentTime() {
        return sim_currentTime;
    }

}
