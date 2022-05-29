/**
 * Please provide your student ID below.
 * 
 * 	Student ID: 2721431
 */

import java.util.ArrayList;

/**
 * RealEstateManager maintains two data structures containing a set of Property objects.
 * The first is an ArrayList called propertyList and the second is a binary tree called
 * propertyTree. Your task is to correctly implement the method bodies for
 * 
 *  protected ArrayList<Property> insertionSort(ArrayList<Property> list)
 *	protected ArrayList<Property> quickSort(ArrayList<Property> list)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local propertyList object as a parameter. You can observe calls to these public
 *  methods in the go methods of RealEstateTest.java.  
 */
public class RealEstateManager
{
	private ArrayList<Property>	propertyList;
	private BinaryTree			btree;
	
	public RealEstateManager()
	{
		propertyList = new ArrayList<Property>();
		btree = new BinaryTree();
	}
	
	public void clear()
	{
		propertyList.clear();
		btree.clear();
	}
	public void addProperty(Property v)
	{
		propertyList.add(v);
		btree.addNode(v);
	}
	
	public void describePropertyList()
	{
		for (Property v : propertyList)
		{
			System.out.println(v.toString());
		}
	}
	
	public void describePropertyTree()
	{	
		btree.printTree();
	}
	
	public String inWalk()
	{
		return btree.inOrderTraversal();
	}

	public Property find(String name)
	{
		return btree.find(name);
	}
	
	/**
	 * This method should use a binary search approach to find for
	 * the property (based on the size) in the ArrayList 'propertyList'.
	 * 
	 * You should not modify this code.
	 * 
	 * @param name Property name to be found
	 * @return	The ArrayList 'property' that has been sorted using  sort
	 */
    public Property binarySearch(double size)
    {	
    	return binarySearch(propertyList, size);
    }
    
    /**
	 * This method should use a binary search approach to find for
	 * the property (based on its size) in the ArrayList 'propertyList'.
	 *
     * @param list An ArrayList of Property objects to search
	 * @param size Property size to be found
 	 * @return	The ArrayList of Properties that has been sorted using insertion sort
	 */
    protected Property binarySearch(ArrayList<Property> list, double size)
    {
		// Use the binary search algorithm to  
		// Initially this method just returns null - you need to fix this.
    	Property p = null;
    	list = insertionSort(true, "size");		// [12] Calling the sorted list for size from the method insertionSort
    	int first = 0;
    	int last = list.size() - 1;
    	
    	while (first <= last) {					// [12] while... loop that will stop when first and last is the same value
	    	int mid = first + ((last - first) / 2);		// [12] Finding the midpoint of the sorted list 
	    	if (list.get(mid).getSize() == size) {		// [12] Checking if its the size we wanted
	    		p = list.get(mid);
	    	}
	    	if (list.get(mid).getSize() < size) {		// [12] Checking if the the size we want is greater than the value at the current midpoint/mid value
	    		first = mid + 1;
	    	}
	    	else {										// [12] Checking if the size we want is smaller than the value at the current midpoint/mid value
	    		last = mid - 1;
	    	}
    	}
    	return p;
    }
	    
	/**
	 * This method should use an insertion sort approach to rearrange
	 * the references in the ArrayList 'propertyList' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * You should not modify this code.
	 * 
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute that will be use during the sorting 
	 * @return	The ArrayList 'property' that has been sorted using insertion sort
	 */
    public ArrayList<Property> insertionSort(boolean asc, String attr)
    {	
    	return insertionSort(propertyList, asc, attr);
    }
    
	/**
	 * This method should use an insertion sort approach to rearrange
	 * the references in the ArrayList 'list' such that they are in 
	 * order according to the attr (attribute) parameter (ascending if asc is true, descending otherwise).
	 * 
     * @param list An ArrayList of Property objects that need sorting
     * @param ascending True if the list should be ascending order, false for descending 
     * @param attr Attribute that will be use during the sorting - either "price" or "size" 
 	 * @return	The ArrayList of Properties that has been sorted using insertion sort
	 */
    protected ArrayList<Property> insertionSort(ArrayList<Property> list, boolean ascending, String attr)
    {
		// Use the insertion sort algorithm to sort 'properties' and then 
		// return it. Initially this method just returns an empty
    	// list - you need to fix this.
    	ArrayList<Property> sorted = new ArrayList<Property>();
    	for (int i = 0; i < list.size(); i++) {		// [11] Making the sorted values = the list values
    		sorted.add(list.get(i));
    	}
    	
    	if (attr == "size") {
	    	for (int i = 1; i < sorted.size(); i++) {
	    		Property key = sorted.get(i);		// [11] This is to allow for the entire node to be moved along the ArrayList rather than just one attribute of it
	    		int j = i - 1;
	    		if (ascending == true) {			// [11] If... statement to get the list in ascending order
	    			while (j > -1 && sorted.get(j).getSize() > key.getSize()) {
	    				sorted.set(j + 1, sorted.get(j));	// [11] This loop compares the two neighbouring values and switches them, if need be, until it reaches the end of the ArrayList
	    				j--;
	    			}
	    		}
	    		if (ascending == false) {			// [11] If... statement to get the list in descending order
	        		while (j > -1 && sorted.get(j).getSize() < key.getSize()) {
		    			sorted.set(j + 1, sorted.get(j));	// [11] similar concept to earlier just with an operator flipped around for correct comparison to get the list in descending order
	        			j--;
	        		}
	        	}
	    		sorted.set(j + 1, key);
	    	}
    	}
    	else {		//similar to the if... statement above however with getSize() and setSize() switched with getPrice() and setPrice()
    		for (int i = 1; i < sorted.size(); i++) {
	    		Property key = sorted.get(i);
	    		int j = i - 1;
	    		if (ascending == true) {
	    		while (j > -1 && sorted.get(j).getPrice() > key.getPrice()) {
	    			sorted.set(j + 1, sorted.get(j));
	    			j--;
	    		}
	    		}
	    		if (ascending == false) {
	        		while (j > -1 && sorted.get(j).getPrice() < key.getPrice()) {
		    			sorted.set(j + 1, sorted.get(j));
	        			j--;
	        		}
	        		}
	    		sorted.set(j + 1, key);
	    	}
    	}
    	
    	return sorted;
    }
}