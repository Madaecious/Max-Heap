//#######################################################################################
// Class Representing and Integer Heap
// -----------------------------------------------------------
// Mark Barros
// CS2400 - Data Structures and Advanced Programming
// California State Polytechnic University: Spring 2021
//#######################################################################################

public class MaxHeap implements MaxHeapInterface {
	
	// Data Fields ----------------------------------------------------------------------
	private Integer [] heap;
	private int lastIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	private int sequentialSwapCount = 0;
	private int optimalSwapCount = 0;
	
	// Constructors ---------------------------------------------------------------------

	// Default Constructor
	public MaxHeap() { this(DEFAULT_CAPACITY); }
	
	// Sequential Constructor
	public MaxHeap(int initialCapacity) {

		if(initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			checkCapacity(initialCapacity);

		Integer [] tempHeap = new Integer[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
		initialized = true;		
	} // end sequential constructor
	
	// Optimal Constructor
	public MaxHeap(Integer [] entries) {
		this(entries.length);
		initialized = true;

		// Copy given array to data field
		for(int index = 1; index < entries.length; index++) {
			heap[index] = entries[index];
			lastIndex++;
		}

		// Create heap
		for(int rootIndex = lastIndex /2; rootIndex > 0; rootIndex--) {
			reheap(rootIndex);
			optimalSwapCount++;
		}

	} // end optimal constructor
	
	// Accessors ------------------------------------------------------------------------
	
	// Returns the max Integer value in the heap.
	public Integer getMax() {
		checkInitialization();
		Integer root = 0;
		if(!isEmpty()) root = heap[1];
		return root;
	} // end getMax
	
	// Returns the entry at the given heap index.
	public Integer getValueAt(int entryIndex) {

		if((entryIndex < 1) || (entryIndex > heap.length - 1)) {
			System.out.println("Your entry index is invalid.");
			return null;
		} else {
			return heap[entryIndex];
		} // end if

	} // end getValueat

	// Status Methods -------------------------------------------------------------------
	
	// Checks to see if the heap is initialized.
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("Heap is corrupt.");
	} // end checkInitialization
	
	// Returns whether the Integer heap is empty or not.
	public boolean isEmpty() {
		return lastIndex < 1;
	}
	
	// Returns the size of the integer heap.
	public int getSize() {
		return lastIndex;
	}
	
	// Checks the capacity of the heap and throws an exception if the requested
	// capacity is too large.
	private void checkCapacity(int capacity) {

		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException(
					"Attempt to create a heap whose capacity " +
					"exceeds allowed maximum of " + MAX_CAPACITY + ".");
		}

	} // end checkCapacity

	// Ensures the heap's capacity is not exceeded.
	private void ensureCapacity() {

		if(lastIndex + 1 == heap.length)
			throw new IllegalStateException("Attempt to exceed the heap's capacity of "
					+ getSize() + ".");

	} // end ensureCapacity
		
	public int getSequentialSwapCount() {
		return sequentialSwapCount;
	}
	
	public int getOptimalSwapCount() {
		return optimalSwapCount;
	}
	
	// Mutators -------------------------------------------------------------------------
	
	// Clears the entire heap.
	public void clear() {
		checkInitialization();

		while(lastIndex > -1) {
			heap[lastIndex] = 0;
			lastIndex--;
		}

		lastIndex = 0;
	} // end clear
	
	// Removes the max integer value from the heap.
	public Integer removeMax() {
		checkInitialization();
		Integer root = null;

		if(!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}

		return root;
	} // end removeMax

	// Adds a new integer value to the max heap using the sequential method.
	public void add (int newEntry) {
		checkInitialization();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		Integer newIntegerEntry = newEntry;

		while((parentIndex > 0) && newIntegerEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
			sequentialSwapCount++;
		}

		heap[newIndex] = newIntegerEntry;
		lastIndex++;
		ensureCapacity();
	} // end add
		
	// Reheaps the heap.
	private void reheap(int rootIndex) {
		boolean done = false;
		Integer orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;

		while(!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;

			if((rightChildIndex <= lastIndex &&
					heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)) {
				largerChildIndex = rightChildIndex;
			}

			if(orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			} else
				done = true;
		} // end while

		heap[rootIndex] = orphan;

	} // end reheap
	
} // End of maxHeap. ####################################################################
