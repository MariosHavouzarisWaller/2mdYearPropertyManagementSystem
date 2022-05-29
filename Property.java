/**
 * Please provide your student ID below.
 * 
 * 	Student ID: 2721431
 */
/**
 * Property is the base class for all Property types.
 * 
 */

public class Property implements Comparable<Property> {
	protected String name;			// The name of the property
	protected double size;			// The size (in squared meters) of the property
	protected double price;			// The price of the property
	protected boolean rent;			// The negotiation type - true for rent, false for sell
	protected int interested;		// Number of customers interested in the property
	protected int maxInterested;	// Maximum number of customer interested in the property 
	protected int yearsSinceLastSale; // [1] Number of years since the property was last sold
	protected boolean onMarket;		// [4] boolean to check if property is on the market - true for yes, false for no
	
	/**
	 * Default Constructor 
	 */
	public Property() {
		name = "?";
		size = 0.0;
		price = 0.0;
		interested = 0;
		maxInterested = 10;
		rent = false;
		yearsSinceLastSale = -1;
		onMarket = false;
	}
	
	/**
	 * Constructs a property based on its name
	 * 
	 * @param nm The name to give to the property
	 */
	public Property(String nm) {
		this();
		name = nm;
	}

	/**
	 * Constructs an property based on its name and size
	 * 
	 * @param nm The name to give to the property
	 * @param sz The size of the property
	 */
	public Property(String nm, double sz) {
		this();
		name = nm;
		size = sz;
	}
	// [2] New constructor for Property based on its name, size and the years that have passed since it was last sold
	// @param nm The name given to the property
	// @param sz The size of the property
	// @param yrs The number of years that have passed since the property was last sold
	public Property(String nm, double sz, int yrs) {
		this();
		name = nm;
		size = sz;
		yearsSinceLastSale = yrs;
	}

	/**
	 * @return The name of property
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the price of the current property
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param prc Price of the current property
	 */
	public void setPrice(double prc) {
		this.price = prc;
	}

	/**
	 * @return the price of the current property
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * @param prc Price of the current property
	 */
	public void setSize(double sz) {
		this.size = sz;
	}
	
	/**
	 * @return the negotiation status of the current property
	 */
	public boolean isRent() {
		return this.rent;
	}
	
	/**
	 * @param r Negotiation status of the current property
	 */
	public void isRent(boolean r) {
		this.rent = r;
	}

	/**
	 * @param inter - add this many interested customer to this property
	 * @return true if the interested customers were added successfully
	 */
	public boolean addInterested(int inter) {
		this.interested = (this.interested + inter);
		if (inter <= this.maxInterested) {	// [3] if...else statement to ensure if an interested party can be added to the list
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return the number of interested customer allocated to this property
	 */
	public int getInterested() {
		return this.interested;
	}
	
	/**
	 * Get a description of the property as a String
	 */
	public String toString()
	{
		return "Property - " + name + ": Size " + size + "; Price " + price;
	}
	
	/**
	 * @return true if this Property is the same at "that" Property
	 * (that is, the two property have the same name)
	 */
	@Override
	public boolean equals(Object that) {
		return this.compareTo(((Property)that)) == 0;
	}

	/**
	 * Compare the current Property with the Property 'that' and return a negative
	 * value if the current Property is less than 'that', 0 if it is the same and
	 * a positive value if it is greater.
	 */
	@Override
	public int compareTo(Property that) {
		return name.compareTo(that.name);
	}
	
	// [1] @return The number of years it's been since the properties last sale
	public int getYearsSinceLastSale() {
		return yearsSinceLastSale;
	}
	
	// [1] @param The number of years it's been since the properties last sale
	public void setYearsSinceLastSale(int yrs) {
		this.yearsSinceLastSale = yrs;
	}
	
	// [4] @return if property is on the market
	public boolean isOnMarket() {
		return this.onMarket;
	}
	
	// [5] @return property being on the market
	public boolean putOnMarket() {
		this.onMarket = true;
		return this.onMarket;
	}
	
	// [5] @return property being off the market
	public boolean takeOffMarket() {
		this.onMarket = false;
		return this.onMarket;
	}
}
