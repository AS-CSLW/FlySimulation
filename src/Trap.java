
public class Trap {
	private int m_length;
	private double m_xlength;
	private double m_ylength;

	public Position p1, p2;


	private Line m_line;

	private Room room;

	public trap(Line line, Position postion, Position position, double length)
	{
		m_line = line;
		m_length = length;
	}
	public Line getLine() {return m_line;}
	public double getSize(){return m_length;}

	Line entity;
	Room room;
	

	Trap(Room r,Position p1,Position p2) {
		//a temporary constructor method, just for trail.
		//so Position p1 and p2 are not examed;
		this.room = r;
		this.entity = new Line(p1,p2);
	}
	
	public Line getLine() {
		return entity;
	}
}
