
public interface DequeueInterface<T> {

	/** Adds a new entry to the back of this queue.
        @param newEntry  An object to be added to the queue. */
	public void addToBack(T newEntry);
	
	/** Adds a new entry to the front of this queue.
    	@param newEntry  An object to be added to the queue. */
	public void addToFront(T newEntry);
	
	 /** Removes and returns this queue's front entry.
    	@return  The object at the front of the queue. 
    	@throws  EmptyQueueException if the queue is empty before the operation. */
	public T removeFront();
	
	/** Removes and returns this queue's back entry.
    	@return  The object at the back of the queue. 
    	@throws  EmptyQueueException if the queue is empty before the operation. */
	public T removeBack();
	
    /** Retrieves this queue's front entry.
    	@return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getFront();
	
	/** Retrieves this queue's back entry.
    @return  The object at the back of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getBack();
	
	/** Removes all entries from this queue. */
	public void clear();
	
	public boolean isEmpty();
}
