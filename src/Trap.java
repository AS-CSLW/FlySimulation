//Author Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
import java.util.Random;

public class Trap {
	double length;
	// call the line.
	public Line entity;
	// call the room
	Room room;
	// define the two points in the trap segment.
	Position firstPointOfTrap, secondPointOfTrap;
	// coordination of the points
	double XOfFirstPoint, YOfFirstPoint, XOFSecondPoint, YOFSecondPoint;
	private static Random tempR = new Random();
	// the trap. find the first trap position and determine the second position based on the length. 
	Trap(Room r,double length) {
		do {
			XOfFirstPoint = room.Xmin + (room.Xmax-room.Xmin) * tempR.nextDouble();
			YOfFirstPoint = room.Ymin + (room.Ymax-room.Ymin) * tempR.nextDouble();
			firstPointOfTrap = new Position(XOfFirstPoint,XOfFirstPoint);
		}while(!r.pointIsInTheRoom(firstPointOfTrap));
		do {
			XOFSecondPoint = room.Xmin + length * Math.cos(tempR.nextDouble() * 2 * Math.PI);
			YOFSecondPoint = room.Ymin + length * Math.sin(tempR.nextDouble() * 2 * Math.PI);
			secondPointOfTrap = new Position(XOFSecondPoint,YOFSecondPoint);
		}while(!r.pointIsInTheRoom(secondPointOfTrap));
		this.entity = new Line(firstPointOfTrap, secondPointOfTrap);
	}

	Trap(Room r,Position p1,Position p2) {
		//a temporary constrctor method, just for trail.
		//so Position p1 and p2 are not examed;
		this.room = r;
		this.entity = new Line(p1,p2);
	}

	public Line getLine() {
		return entity;
	}
}
