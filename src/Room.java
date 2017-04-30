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

	
	public boolean checkAcross(Position begin,Position end) {
		Line line = new Line(begin, end);

		//Cong: this method check whether the imaginary path intersect with boundary (cause knock into boundary event)
		return true;
	}

	public Line returnAcrossWall(Position begin,Position end) {


	
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
