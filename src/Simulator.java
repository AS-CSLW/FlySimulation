// Author: Xiaoyang MENG, Wuchang LI, Cong DU, Soowoo CHANG
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

//singleton
public class Simulator {

    //singleton
    private static SimulatorEngine instance = null;

    public static SimulatorEngine getSim() {
        if(instance == null) {
            instance = new SimulatorEngine();
        }
        return instance;
    }

    public static void stopAt(double time) {
        Event stopEvent = new SimulatorEvent(time, getSim(), SimulatorEvent.STOP_EVENT);
        schedule(stopEvent);
    }

    public static void run() {
        getSim().run();
    }

    public static double getCurrentTime() {
        return getSim().getCurrentTime();
    }

    public static double getPrintableTime() {
        return Math.round(getCurrentTime() * 10000.000) / 10000.000;
    }
    
    public static void schedule(Event event) {
        event.setTime(event.getTime() + getSim().getCurrentTime());
        getSim().schedule(event);
        
    }
    
    public static void restart() {
    	instance = null;
    }
}
