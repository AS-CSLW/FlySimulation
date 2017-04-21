import java.util.ArrayList;
import java.util.List;

public class Room {
	public List<Line> boundarys = null;
	//information to help drawing. or automate generate fly in room randomly (combine with isInsideRoom method).
	private double Xmax,Xmin,Ymax,Ymin;
	
	/*
	 * Cong: assume the boundary of room is always described as polygon.
	 * 		the boundarys should be a series of points in clockwise order or anticlockweise order.
	 */
	Room(List<Position> b) {
		boundarys = null;
	}
	
	public boolean checkAcross(Position begin,Position end) {
		//Cong: this method check whether the imaginary path intersect with boundary (cause knock into boundary event)
		return true;
	}
	
	public Line AcrossWall(Position begin,Position end) {
		//return the intersected wall
		return new Line(new Position(0,0),new Position(1,1));
	}
	
	
	
}
