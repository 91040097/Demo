package linear;

import java.util.NoSuchElementException;

public class Exam1Prep {

	public static void main(String[] args) {
		Node<Integer> x = new Node<Integer>(3, new Node<Integer>(4, new Node<Integer>
		(5, new Node<Integer>(7, null))));
		
		x.next.next.next.next = x;
		
		printListCLL(x);
		
		x = deleteAll(3, x);
		
		printListCLL(x);
		
		//Node<Integer> y = new Node<Integer>(4, new Node<Integer>(5, null));
		
		//printList(y);
		
		//Node<Integer> c = commonElements(x, y);
		
		//printList(c);
	}
	public static Node<Integer> commonElements(Node<Integer> frontL1, Node<Integer> frontL2)
	{
		Node<Integer> tmp1 = frontL1, tmp2 = frontL2, n = null, head = n;
		
		while(tmp1 != null && tmp2 != null)
		{
			if((int)tmp1.data < (int)tmp2.data)
				tmp1 = tmp1.next;
			else if((int) tmp2.data < (int) tmp1.data)
				tmp2 = tmp2.next;
			else
			{
				if(n == null)
				{
					n = new Node<Integer>(tmp1.data, null);
					
					head = n;
				}
				else
				{
					n.next = new Node<Integer>(tmp1.data, null);
					
					n = n.next;
				}
				
				tmp1 = tmp1.next;
				tmp2 = tmp2.next;
			}
		}
		
		return head;
	}
	
	public static<T> Node<T> deleteAll(T item, Node<T> rear) throws NoSuchElementException
	{
		int c = 0;
		
		Node<T> tmp = rear.next, prev = rear;
		
		do
		{
			if(tmp.data == item)
			{
				c++;
				
				if(tmp == rear)
				{
					prev.next = tmp.next;
					
					rear = prev;
					
					return rear;
				}
				else
					prev.next = tmp.next;
			}
			
			prev = tmp;
			tmp = tmp.next;
		}while(prev != rear);
		
		if(c == 0)
			throw new NoSuchElementException();
		else
			return rear;
	}
	
	public static void printList(Node<Integer> tmp)
	{
		while(tmp != null)
		{
			System.out.print(tmp.data + " ");
			
			tmp = tmp.next;
		}
		
		System.out.println();
	}
	
	public static<T> void printListCLL(Node<T> tmp)
	{
		Node<T> x = tmp;
		
		int c = 0;
		
		do
		{
			System.out.print(x.data + " ");
			
			x = x.next;
			
			c++;
		}while(x != tmp && c < 4);
		
		System.out.print(x.data);
		
		System.out.println();
	}

}
