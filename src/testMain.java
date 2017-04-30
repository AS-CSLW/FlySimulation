/**
 * Created by wuchangli on 4/29/17.
 */
public class testMain {
    public static void main(String []args) {
        Position a1 = new Position(1,2);
        Position a2 = new Position(1,3);
        Position b1 = new Position(10,4);
        Position b2 = new Position(5,4);
        Line line1 = new Line(a1,a2);
        Line line2 = new Line(b1,b2);
        Position intersectPoint;
        intersectPoint = Line.intersectPos(line1, line2);



                System.out.println("x is" + intersectPoint.X + " y is" + intersectPoint.Y);
    }
}
