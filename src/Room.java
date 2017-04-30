/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<Line> boundarys = null;


	private Position p1, p2, p3, p4;

	// Xiaoyang: this is always a 4 segments polygon. not necessary to be a square.
	public Room (Position Xmax, Position Xmin, Position Ymax, Position Ymin)
	{
		p1 = Xmax;
		p2 = Xmin;
		p3 = Ymax;
		p4 = Ymin;
	}

	// Xiaoyang: give the position of the corners of this polygon. 
	public static void main(String args[]) {
		Position Room[] = {new Position(0, 0), new Position(10, 0),
				new Position(10, 10), new Position(0, 10)};
	}

	public  static boolean checkAcross(Position p,Position q, Position r) {
		if (q.X <= Math.max(p.X, r.X) && q.X >= Math.min(p.X, r.X)
				&& q.Y <= Math.max(p.Y, r.Y) && q.Y >= Math.min(p.Y, r.Y))
		//Xiaoyang: this method check whether the imaginary path intersect with boundary (cause knock into boundary event)
		return true;
	}
	
	public Line returnAcrossWall(Position p,Position r) {
		//return the intersected wall
		p1 = p;
		p3 = r;
		return new Line(new Position(0,0),new Position(1,1));
	}
	
	public List<Line> returnWall() {
		return this.boundarys;
	}
	
	
}
