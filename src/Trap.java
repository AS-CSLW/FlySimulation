
public class Trap {
	double length;
	Line entity;
	Room room;
	
	Trap(Room r,double l) {
		
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
