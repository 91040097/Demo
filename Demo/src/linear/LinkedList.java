package linear;

import java.util.NoSuchElementException;

public class LinkedList {
	public CLLNode rear;
	
	public LinkedList(String data, CLLNode next)
	{
		next.next = rear;
		
		rear = new CLLNode(data, next);
	}
	
	public boolean delete(String target)
	{
		CLLNode tmp = rear.next, prev = rear;
		
		do
		{	
			if(rear == null)
				return false;
			
			if(rear == rear.next)
			{
				if(rear.data.equals(target))
				{
					rear = null;
					
					return true;
				}
				else
					return false;
			}
			
			if(tmp.data.equals(target))
			{	
				prev.next = tmp.next;
				
				if(tmp == rear)
					rear = prev;
				return  true;
			}
			
			prev = tmp;
			
			tmp = tmp.next;
		}while(prev != rear);
		
		return false;
	}
	public boolean addAfter(String newItem, String afterItem)
		     throws NoSuchElementException {
		
		CLLNode tmp = rear;
		
		if(rear == null)
			return false;
		
		if(rear.data.equals(afterItem))
		{
			CLLNode head = rear.next;
			
			rear.next = new CLLNode(newItem, head);
			
			rear = rear.next;
			
			return true;
		}
		
		do
		{
			if(tmp.data.equals(afterItem))
			{
				CLLNode x = tmp.next;
				
				tmp.next = new CLLNode(newItem, x);
				
				return true;
			}
			
			tmp = tmp.next;
		}while(tmp != rear);
		
		return false;
	} 

}
