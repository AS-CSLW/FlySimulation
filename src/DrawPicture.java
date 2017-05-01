
public class DrawPicture {
	private static Room room = null;
	private static double height;
	private static double width;
	
	public static void init(Room r){
		room = r;
		height = room.Ymax - room.Ymin;
		width = room.Xmax - room.Xmin;
		StdDraw.setCanvasSize((int)(width*80), (int)(height*80));
		StdDraw.setPenRadius(0.004);
	}
	
	public static void drawRoom() {
		StdDraw.setPenColor(StdDraw.BLACK);
		for(Line b:room.returnWall()){
			drawLine(b);
		}
	}
	
	public static void drawTrap(Trap t) {
		StdDraw.setPenColor(StdDraw.BLUE);
		drawLine(t.getLine());
	}
	
	private static void drawLine(Line l) {
		StdDraw.line((l.p1.X/width)*0.8+0.1, (l.p1.Y/height)*0.8+0.1, (l.p2.X/width)*0.8+0.1, (l.p2.Y/height)*0.8+0.1);
	}
	


}
