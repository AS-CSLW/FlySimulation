/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
public class Line {
	public Position p1,p2;
	public double coefficientOfLine1;
	Line(Position pos1,Position pos2) {
		p1 = pos1;
		p2 = pos2;
	}
	
	static public boolean doInteresct(Line l1, Line l2) {
		return Position.doIntersect(l1.p1, l1.p2, l2.p1, l2.p2);
	}
	
	static public Position intersectPos(Line l1,Line l2) {
		return 
	}
	
	
}
