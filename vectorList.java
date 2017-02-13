import java.util.Vector;

public class vectorList<T> implements ListInterface<T> {

	private Vector<T> list;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	private int numberOfEntry;
	
	public vectorList(){
		this(DEFAULT_CAPACITY);
	}
	
	public vectorList(int initialCapacity) {
	   checkCapacity(initialCapacity);
	   list = new Vector<>(initialCapacity);
	   initialized = true;
	   numberOfEntry = 0;
	}

	public void checkCapacity(int capacity){
		if(capacity>MAX_CAPACITY)
			throw new SecurityException("The input is more than Max capacity");
	}

	public void checkInitialization() {
		if(!initialized)
			throw new SecurityException("List object is not initialized" + "properly");
	}
	
	@Override
	public boolean add(T item) {
		checkInitialization();
		if(list.capacity() > numberOfEntry){
		    list.add(item);
		    numberOfEntry++;
		    return true;
		}
		return false;
	}

	@Override
	public boolean add(T item, int index) {
		checkInitialization();
		if(list.capacity() > numberOfEntry){
		    list.add(index, item);
		    numberOfEntry++;
		    return true;
		}
		return false;
	}

	@Override
	public boolean remove(int index) {
		if(numberOfEntry > index){
		   list.remove(index);
		   return true;
		}
		return false;
		
	}

	@Override
	public void removeAll() {
		list.removeAllElements();
	}

	@Override
	public boolean replaceItem(T item, int giveIndex) {
		if(numberOfEntry > giveIndex){
		     list.setElementAt(item, giveIndex);
		     return true;
		}
		return false;
	}

	@Override
	public int lookAt(T item) {
		if(list.contains(item)){
			int index=list.indexOf(item) ;
			return index;
		}
		return -1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] lookAll() {
		T [] temp = (T[]) list.toArray();
		return temp;
	}

	@Override
	public boolean contain(T item) {
		return list.contains(item);
	}

	@Override
	public int countTotal() {
		return numberOfEntry;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
