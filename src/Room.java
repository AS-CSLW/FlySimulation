/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
//Xiaoyang:
public class Room {

    public Position p1, p2, p3, p4;
    public Line l1, l2, l3, l4;

    public Room(Line L1, Line L2, Line L3, Line L4)
    {
        l1 = L1;
        l2 = L2;
        l3 = L3;
        l4 = L4;
    }

	private List<Line> boundarys = null;


	// Xiaoyang: give the position of the corners of this polygon.


	public boolean checkAcross(Position p,Position q, Position r) {
		if (q.X <= Math.max(p.X, r.X) && q.X >= Math.min(p.X, r.X)
				&& q.Y <= Math.max(p.Y, r.Y) && q.Y >= Math.min(p.Y, r.Y))
		//Xiaoyang: this method check whether the imaginary path intersect with boundary (cause knock into boundary event)
		return true;
	}
	
	public Line returnAcrossWall(Position p,Position r) {
		//return the intersected wall

		return new Line(new Position(0,0),new Position(1,1));
	}
	
	public List<Line> returnWall() {
		return this.boundarys;
	}
	
	
}
