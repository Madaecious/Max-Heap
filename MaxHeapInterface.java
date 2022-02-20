//#######################################################################################
// Interface that Describes the Operations of an Integer Max Heap
// --------------------------------------------------------------------
// Mark Barros
// CS2400 - Data Structures and Advanced Programming
// California State Polytechnic University: Spring 2021
//#######################################################################################

public interface MaxHeapInterface {
	
	/** Adds a new Integer entry to the max heap.
	 * @param newEntry The new integer entry to be added to the heap. */
	public void add (int newEntry);
	
	/** Removes the top Integer entry from the heap.
	 * @return int The top integer entry from the heap */	
	public Integer removeMax();
	
	/** Gets the max Integer entry from the heap.
	 * @return int The max integer from the heap.  */	
	public Integer getMax();
	
	/** Determines if the Integer heap is empty.
	 * @return boolean True if the heap is empty; False otherwise. */	
	public boolean isEmpty();
	
	/** Gets the size of the integer heap.
	 * @return int The size of the integer heap. */	
	public int getSize();
	
	/** Clears the integer heap. */
	public void clear();
	
} // end MaxHeapInterface ###############################################################
