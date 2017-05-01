/// Authors: Xiaoyang MENG, Cong DU, Soowoo CHANG, Wuchang LI
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<Line> boundaries = null;
	public double Xmax = 0,Xmin = 0,Ymax = 0,Ymin = 0;
	Room(){
		int i = 0;
		for(Line boundary : boundaries){
			Line tempLine1, tempLine2;
			tempLine1 = boundaries.get(i);
			tempLine2 = boundaries.get(i+1);
			Position intersectPoint = Line.intersectPos(tempLine1, tempLine2);
			if(intersectPoint.X > Xmax){
					Xmax = intersectPoint.X;
			}
			if(intersectPoint.Y > Ymax){
				Ymax = intersectPoint.Y;
			}
			if(intersectPoint.X < Xmin){
				Xmin = intersectPoint.X;
			}
			if(intersectPoint.Y < Ymin){
				Ymin = intersectPoint.Y;
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
		if (pointIsInTheRoom(begin) || pointIsInTheRoom(end)){
			return true;
		}else{
			return false;
		}
	}


	public Line returnAcrossWall(Position p,Position r) {
		Line flyLine = new Line(p,r);
		int i = 0;
		for(Line boundaries : boundaries)
		{
			i++;
			if(Line.doInteresct(flyLine, boundaries))
				break;
		}
		return boundaries.get(i);

	}

	public List<Line> returnWall(){
			return this.boundaries;
	}


}
