
public interface ListInterface<T> {

	/**
	 *  add a item to list
	 * @param item the item to be add to List
	 * @return if successes return true, else return false
	 */
	public boolean add(T item);
	
	/**
	 * add a item to given Index
	 * @param item The item needs to add
	 * @param index the position for insert
	 * @return if successes return true, else return false
	 */
	public boolean add(T item,int index);
	
	/**
	 * remove the item from given position 
	 * @param index the specific position for remove
	 * @return if successes return true, else return false
	 */
	public boolean remove(int index);
	
	/**
	 * remove all elements from the list
	 */
	public void removeAll();
	
	/**
	 * given a position then replace the item
	 * @param item replace this new Item
	 * @param giveIndex  the specific position for replace
	 * @return if successes return true, else return false
	 */
	public boolean replaceItem(T item,int giveIndex);
	
	/**
	 * give a item to find the position
	 * @param item use it for search list
	 * @return return the position if found ,else return -1
	 */
	public int lookAt(T item);
	
	/**
	 * give back each elements 
	 * @return copy elements in type T array
	 */
	public T[] lookAll();
	
	/**
	 * check the item is existing or not
	 * @param item the Item for check if it existing
	 * @return if found the item return true, else return false;
	 */
	public boolean contain(T item);
	
	/**
	 * tell user how many elements in the list
	 * @return number of Entry
	 */
	public int countTotal();
	
	/**
	 * check list is empty or not
	 * @return if list is empty return true,else reutrn false
	 */
	public boolean isEmpty();
	
}
