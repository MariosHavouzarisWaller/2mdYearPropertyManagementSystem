// Student ID: 2721431

public class Commercial extends Property
{
	protected int rooms;
	protected double facadeLength;
	
	public Commercial(String n, double sz, int rms, double fcd) {
		super(n, sz);
		this.rooms = rms;
		this.facadeLength = fcd;
	}
	
	public String toString()
	{
		return "Commercial - " + name + " : Size " + getSize() + "; Rooms " + rooms + "; Facade Length " + facadeLength; 
	}
}