import java.util.ArrayList;
public class FlySim {
	private static final int simulationTime = 300;
	private static final int numberOfFly = 500;
	private static final int repeatTimes = 100;
	
	public static void main(String[] args) {
		ArrayList<Line> boundaries = new ArrayList<Line>();
		boundaries.add(new Line(0.0,0.0,0.0,10.0));
		boundaries.add(new Line(0.0,10.0,10.0,13.0));
		boundaries.add(new Line(10.0,13.0,10.0,0.0));
		boundaries.add(new Line(10.0,0.0,0.0,0.0));
		
		Room ourRoom = new Room(boundaries);
		Trap bestTrap = null;
		double eliminationRate = 0;
		for(int j=0;j<repeatTimes;++j){
			Trap currentTrap = new Trap(ourRoom,0.4);
			for(int i=0;i<numberOfFly;++i) {
				Fly oneFly = new Fly(ourRoom,currentTrap);
				FlyEvent oneEvent = new FlyEvent(0.0,oneFly,FlyEvent.changeDirection);
				Simulator.schedule(oneEvent);
			}
			Simulator.stopAt(simulationTime);
			Simulator.run();
			System.out.println("the elimination rate of this trap is " + Fly.retStat());
			if(Fly.retStat()>eliminationRate){
				bestTrap=currentTrap;
				eliminationRate=Fly.retStat();
			}
			Simulator.restart();
			Fly.resetStat();
		}
			System.out.println("the best elimination rate of the best trap is "+eliminationRate);
			DrawPicture.init(ourRoom);
			DrawPicture.drawRoom();
			DrawPicture.drawTrap(bestTrap);

		
	}
}
