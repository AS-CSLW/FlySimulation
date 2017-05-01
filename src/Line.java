/// Authors: Xiaoyang MENG, Cong DU, Soowon CHANG, Wuchang LI
public class Line {
	// equation: (y-p1.Y) = m(x-p1.X)
	public Position p1,p2;
	// m
	private double coefficientOfSlope;
	
	Line(Position pos1,Position pos2) {
		p1 = pos1;
		p2 = pos2;
		coefficientOfSlope = (p1.Y-p2.Y)/(p1.X-p2.X);
	}
	
	Line(double x1, double y1, double x2, double y2) {
		p1 = new Position(x1,y1);
		p2 = new Position(x2,y2);
		coefficientOfSlope = (p1.Y-p2.Y)/(p1.X-p2.X);
	}
	
	static public boolean doInteresct(Line l1, Line l2) {
		return Position.doIntersect(l1.p1, l1.p2, l2.p1, l2.p2);
	}
	
	static public Position intersectPos(Line l1,Line l2) {
		Position a = new Position(1,2);
		//coefficientOfSlope1
		//System.out.println("l1 is:"+l1.p1.X+" "+l1.p1.Y+" "+l1.p2.X+" "+l1.p2.Y);
		double m1 = l1.coefficientOfSlope;
		//coefficientOfSlope2
		double m2 = l2.coefficientOfSlope;
		if(Double.isFinite(m1)) {
			a.X = (l2.p1.Y - l1.p1.Y + m1 * l1.p1.X - m2 * l2.p1.X) / (m1 - m2);
			a.Y = m1 * (a.X - l1.p1.X) + l1.p1.Y;
		}else{
			if(!(Double.isFinite(m1))){
				a.X = l1.p1.X;
				a.Y = m2 * (a.X - l2.p1.X) + l2.p1.Y;
			}else{
				a.X = l2.p1.X;
				a.Y = m1 * (a.X - l1.p1.X) + l1.p1.Y;
			}
		}
		return a;
	}


	
	
}
