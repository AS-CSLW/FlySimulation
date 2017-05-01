/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI

import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<Line> boundaries = null;
	public double Xmax = Double.MIN_VALUE,Xmin = Double.MAX_VALUE,Ymax = Double.MIN_VALUE,Ymin = Double.MAX_VALUE;
	Room(List<Line> b) {
		boundaries = b;
		findRoomDomain();
	}
	

	
	private void findRoomDomain(){
		for(Line boundary : boundaries){
			if(boundary.p1.X > Xmax){
					Xmax = boundary.p1.X;
			}
			if(boundary.p1.Y > Ymax){
				Ymax = boundary.p1.Y;
			}
			if(boundary.p1.X < Xmin){
				Xmin = boundary.p1.X;
			}
			if(boundary.p1.Y < Ymin){
				Ymin = boundary.p1.Y;
			}

		}
	}
	// clockwise
	// Xiaoyang: this is always a 4 segments polygon. not necessary to be a square.

	public boolean pointIsInTheRoom(Position a){
		int count = 0;
		Position virtualPoint = new Position((double)(Integer.MAX_VALUE), a.Y);
		Line virtualLine = new Line(a,virtualPoint);
		for(Line boundary : boundaries)
		{
			if(Line.doInteresct(virtualLine, boundary))
				count++;
		}
		
		if(count%2==1)
			return true;
		else
			return false;
	}


	public boolean checkAcross(Position begin,Position end) {
		Line flyroute = new Line(begin,end);
		for(Line b:boundaries) {
			if(Line.doInteresct(b, flyroute))
				return true;
		}
		return false;
	}


	public Line returnAcrossWall(Position begin,Position end) {
		Line flyroute = new Line(begin,end);
		Line result = null;
		double dist = Double.MAX_VALUE;
		for(int i=0;i<boundaries.size();++i)
		{
			
			if(Line.doInteresct(flyroute, boundaries.get(i))) {
				result = boundaries.get(i);
				/*
				Position intersectPoint = Line.intersectPos(flyroute, boundaries.get(i));
				double temp = Position.distance(begin, intersectPoint);
				if(temp < dist){
					dist = temp;
					result = boundaries.get(i);
					}
				*/
				}
			}
		
		return result;

	}

	public List<Line> returnWall(){
			return this.boundaries;
	}


}
