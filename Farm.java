// Student ID: 2721431
public class Farm extends Property 	// Adding a Farm Class
{
	protected boolean hasFarmhouse; // [6]
	protected int numberOfBarns;	// [6]
	
	// [7] Constructs a farm property based on its name, size, if it has a farmhouse, and the number of barns it has
	public Farm(String nm, double sz, boolean frmhs, int nmbrn) {
		super(nm, sz);
		this.hasFarmhouse = frmhs;
		this.numberOfBarns = nmbrn;
	}
	// [8] Method that summarises the Farm object
	public String toString()
	{
		return "Farm - " + name + " : Size " + size + "; Farmhouse " + hasFarmhouse + "; Barns " + numberOfBarns;
	}
}