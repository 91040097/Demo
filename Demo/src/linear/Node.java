package linear;

public class Node <T> {

	T data;
	Node<T> next;
	
	public Node(T data){
		this.data = data;
		
		next = null;
	}
	
	public Node(T data, Node<T> n){
		this.data = data;
		
		next = n;
	}
}