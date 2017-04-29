
public class Position {

	public double X;
	public double Y;
	
	Position() {
	}
	
	Position(double x,double y) {
		X=x;
		Y=y;
	}
	
	private static int orientation(Position p, Position q, Position r) {
		double val = (q.Y - p.Y) * (r.X - q.X) -
					(q.X - p.X) * (r.Y - q.Y);
		if (val == 0.0) return 0;//colinear
		return (val>0.0)?1:2;//return clockwise or counterclockwise
	}
	
	//once p,q,r is colinear, check if they are intersect with each other.
	private static boolean onSegment(Position p, Position q, Position r) {
		if(q.X <= Double.max(p.X, r.X) && q.X >= Double.min(p.X,r.X) &&
			q.Y <= Double.max(p.Y,r.Y) && q.Y >= Double.min(p.Y, r.Y))
			return true;
		return false;
	}
	
	public static boolean doIntersect(Position p1, Position q1, Position p2, Position q2) {
		int o1 = orientation(p1,q1,p2);
		int o2 = orientation(p1,q1,q2);
		int o3 = orientation(p2,q2,p1);
		int o4 = orientation(p2,q2,q1);
		
		//general case
		if(o1 != o2 && o3 !=o4)
			return true;
		
		//special cases, colinear, see http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
		if(o1 == 0 && onSegment(p1,p2,q1)) return true;
		if(o2 == 0 && onSegment(p1,q2,q1)) return true;
		if(o3 == 0 && onSegment(p2,p1,q2)) return true;
		if(o4 == 0 && onSegment(p2,q1,q2)) return true;
		
		return false;
	}
}
