package linear;

public class ProblemSet3 {

	public static void main(String[] args) {
		CLLNode x = new CLLNode("thing", new CLLNode("data", null));
		
		x.next.next = x;
		
		LinkedList y = new LinkedList("thing",new CLLNode("data", null));
		
		y.rear.next.next = y.rear;
		
		printList(y);
		
		//y.delete("data");
		
		//printList(y);
		
		y.addAfter("ggg", "data");
		
		printList(y);
		
		y.addAfter("hhhh", "data");
		
		printList(y);
	}
	public static void printList(CLLNode rear)
	{
		CLLNode tmp = rear;
		
		do
		{
			System.out.print(tmp.data + " ");
			
			if(tmp != null && tmp.next == rear)
				System.out.print(tmp.next.data);
			tmp = tmp.next;
			
		}while(tmp != rear);
		
		System.out.println();
	}
	
	public static void printList(LinkedList x)
	{
		CLLNode tmp = x.rear;
		
		do
		{
			System.out.print(tmp.data + " ");
			
			if(tmp != null && tmp.next == x.rear)
				System.out.print(tmp.next.data);
			tmp = tmp.next;
			
		}while(tmp != x.rear);
		
		System.out.println();
	}
}
