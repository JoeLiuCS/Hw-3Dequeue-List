
public class LinkedDeque<T> implements DequeueInterface<T> {
	
	
	private DLNode<T> firstNode;
	private DLNode<T> lastNode;

	@SuppressWarnings("hiding")
	private class DLNode<T>{
		private T data;
		private DLNode<T> next;
		private DLNode<T> previous;
		
		private  DLNode(T dataPortion){
			this(null,dataPortion,null);
		}

		private DLNode(DLNode<T> previousNode,T dataPortion, DLNode<T>  nextNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		}
		
		public T getData(){
			return data;
		}
		
		@SuppressWarnings("unused")
		public void setData(T newData){
			data = newData;
		}
		
		public DLNode<T> getNextNode(){
			return next;
		}
		
		public void setNextNode(DLNode<T> nextNode){
		    next = nextNode;
		}
		
		public DLNode<T> getPreviousNode(){
			return previous;
		}
		
		public void setPreviousNode(DLNode<T> previousNode){
			previous = previousNode;
		}
	}
	
	public void LinkedDequeue(){
		firstNode = null;
		lastNode = null;
	}
	
	@Override
	public void addToBack(T newEntry) {
		DLNode <T> newNode = new DLNode<T>(lastNode,newEntry,null);
		
		if(isEmpty()){
			firstNode = newNode;
		}
		else{
			lastNode.setNextNode(newNode);
		}
 		lastNode = newNode;
	}

	@Override
	public void addToFront(T newEntry) {
        DLNode <T> newNode = new DLNode<T>(null,newEntry,firstNode);
		
		if(isEmpty()){
			lastNode = newNode;
		}
		else{
			firstNode.setPreviousNode(newNode);
		}
 		firstNode = newNode;
		
	}

	@Override
	public T removeFront() {
		T front = getFront();
		
		assert firstNode != null;
		
		firstNode = firstNode.getNextNode();
		if(firstNode == null){
			lastNode = null;
		}
		else{
			firstNode.setPreviousNode(null);
		}
		return front;
	}

	@Override
	public T removeBack() {
        T back = getBack();
		
		assert lastNode != null;
		
		lastNode = lastNode.getPreviousNode();
		if(lastNode == null){
			firstNode = null;
		}
		else{
			lastNode.setNextNode(null);
		}
		return back;
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}

	@Override
	public T getBack() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return lastNode.getData();
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null)&&(lastNode == null);
	}

}
