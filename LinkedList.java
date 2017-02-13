
public class LinkedList<T> implements ListInterface<T> {

	private Node<T> firstNode;
	private int numberOfEntry;
	private  void initializeDataFields(){
		firstNode = null;
		numberOfEntry = 0;
	}
	
	private Node<T> getNodeAt(int givenPosition){
		Node<T> currentNode = firstNode;
		return getNodeAtRecursing(currentNode,givenPosition);
	}
	
	private Node<T> getNodeAtRecursing(Node<T> currentNode,int givenPosition){
		if(givenPosition == 0){
			return currentNode;
		}
		else{
			return getNodeAtRecursing(currentNode.getNextNode(),givenPosition-1);
		}
	}
	
	@SuppressWarnings("hiding")
	private class Node<T>{
		private T data;
		private Node<T> next;
		
		private Node (T dataPortion){
			this(dataPortion,null);
		}
		private Node(T dataPortion, Node<T> nextNode){
			data = dataPortion;
			next = nextNode;
		}
		
		public T getData(){
			return data;
		}
		
		public void setData(T newData){
			data = newData;
		}
		
		public Node<T> getNextNode(){
			return next;
		}
		
		public void setNextNode(Node<T> nextNode){
			next = nextNode;
		}
	}
	
	public LinkedList(){
		initializeDataFields();
	}
	
	@Override
	public boolean add(T item) {
		Node<T> newNode = new Node<T>(item);
		
		if(isEmpty()){
			firstNode = newNode;
		}
		else{
			Node<T> lastNode = getNodeAt(numberOfEntry);
			lastNode.setNextNode(newNode);
		}
		return false;
	}

	@Override
	public boolean add(T item, int index) {
		if((index >= 1 ) &&(index <= numberOfEntry + 1)){
			Node<T> newNode = new Node<T>(item);
			if(index == 1){
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else{
				Node<T> nodeBefore = getNodeAt(index -1);
				Node<T> nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntry++;
		}
		else 
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
		return false;
	}

	@Override
	public boolean remove(int index) {
		boolean result = false;
		if((index >= 1) && (index <= numberOfEntry)){
			
			assert !isEmpty();
			if(index ==1){
				firstNode = firstNode.getNextNode();
			}
			else{
				Node<T> nodeBefore = getNodeAt(index - 1);
				Node<T> nodeToRemove = nodeBefore.getNextNode();
				Node<T> nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntry--;
			result = true;
		}	
		return result;
	}

	@Override
	public void removeAll() {
		initializeDataFields();
	}

	@Override
	public boolean replaceItem(T item, int giveIndex) {
		if((giveIndex >= 1) && (giveIndex <= numberOfEntry)){
			assert !isEmpty();
			Node<T> desiredNode = getNodeAt(giveIndex);
			desiredNode.setData(item);
			return true;
		}
		return false;
	}

	@Override
	public int lookAt(T item) {
		int index = 0;
		Node<T> currentNode = firstNode; 
		while(currentNode!=null){
			if(item.equals(currentNode.getData())){
				return index;
			}
			index ++;
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	@Override
	public T[] lookAll() {
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntry];
		
		int index = 0;
		Node<T> currentNode = firstNode;
		while((index<numberOfEntry) && (currentNode != null)){
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}

	@Override
	public boolean contain(T item) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while(!found &&(currentNode != null)){
			if(item.equals(currentNode.getData())){
				found = true;
			}
			else{
				currentNode = currentNode.getNextNode();
			}
		}
		return false;
	}

	@Override
	public int countTotal() {
		return numberOfEntry;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if( numberOfEntry == 0){
			assert firstNode == null;
			result = true;
		}
		else{
			assert firstNode != null;
			result = false;
		}
		return result;
	}

}
 