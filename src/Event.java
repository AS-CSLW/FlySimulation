/// Author: Xiaoyang MENG, Wuchang LI, Cong DU, Soowon CHANG

public class Event implements Comparable<Event>{
	private EventHandler m_handler;
	private double sim_time;
	private int sim_eventID;
	private int m_eventType;
    static private int m_nextID = 0;
    
    Event() {
    	sim_eventID = m_nextID++;
    }
    
    Event(double delay, EventHandler handler, int eventType) {
        this();
        sim_time = delay;
        m_handler = handler;
        m_eventType = eventType;
    }
    
    public int getId() {
        return sim_eventID;
    }

    public double getTime() {
        return sim_time;
    }

    public void setTime(double time) {
        sim_time = time;
    }

    public EventHandler getHandler() {
        return m_handler;
    }

    public int getType() { return m_eventType; }

    public void setHandler(EventHandler handler) {
        m_handler = handler;
    }

    
	@Override 
	public int compareTo(final Event otherEvent) {
        int timeCmp = Double.compare(sim_time, otherEvent.getTime());
        if(timeCmp != 0) {
            return timeCmp;
        }
        else
            return Integer.compare(sim_eventID, otherEvent.getId());
	}
}
