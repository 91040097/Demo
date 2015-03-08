package linear;

public class ProblemSet2 {

	public static void main(String[] args) {
		IntNode x1 = new IntNode(5, new IntNode(6, new IntNode(7, new IntNode(9, new IntNode(11, null)))));
		
		IntNode x2 = new IntNode(5, new IntNode(7, new IntNode(11, new IntNode(15, new IntNode(16, null)))));
		
		printList(x1);
		
		printList(x2);
		
		IntNode x = commonElements(x1, x2);
		
		printList(x);
		
		/*StringNode x = new StringNode("thing", new StringNode("data", new StringNode("thing1")));
		
		printList(x);
		
		x = deleteAllOccurrences(x, "thing1");
		
		printList(x);*/
	}
	
	public static IntNode addBefore(IntNode front, int target, int newItem) {
		IntNode tmp = front, prev = null;
		
		if(tmp.data == target)
		{
			front = new IntNode(newItem, tmp);
			
			return front;
		}
		
		prev = front;
		
		tmp = tmp.next;
		
		while(tmp != null)
		{
			if(tmp.data == target)
				prev.next = new IntNode(newItem, tmp);
			prev = tmp;
			
			tmp = tmp.next;
		}
		
		return front;
		}
	
	public static int numberOfOccurrences(StringNode front, String target) {
		StringNode tmp = front;
		
		int c = 0;
		
		while(tmp != null)
		{
			if(tmp.data.equals(target))
				c++;
			tmp = tmp.next;
		}
		
		return c;
	}
	
	public static void printList(IntNode x)
	{
		IntNode tmp = x;
		
		while(tmp != null)
		{
			System.out.print(tmp.data + " ");
			
			tmp = tmp.next;
		}
		
		System.out.println();
	}
	
	public static void deleteEveryOther(IntNode front) {
		IntNode prev = null;
		
		IntNode tmp = front;
		
		for(int i = 1;tmp != null;i++)
		{
			if(i % 2 == 0 && prev != null)
				prev.next = tmp.next;
			
			prev = tmp;
			
			tmp = tmp.next;
		}
	}
	
	public static StringNode deleteAllOccurrences(StringNode front, String target) {
		StringNode prev = null;
		
		StringNode tmp = front;
		
		while(tmp != null)
		{
			if(tmp.data.equals(target) && prev == null)
			{
				front = tmp.next;
				
				tmp = front;
			}
			else if(tmp.data.equals(target) && prev != null)
			{
				prev.next = tmp.next;
			}
			
			prev = tmp;
			
			tmp = tmp.next;
		}
		
		return front;
	}
	
	public static IntNode commonElements(IntNode frontL1, IntNode frontL2) {
		IntNode tmp1 = frontL1, tmp2 = frontL2, list = null, front = null;
		
		while(tmp1 != null && tmp2 != null)
		{
			if(tmp1.data < tmp2.data)
				tmp1 = tmp1.next;
			else if(tmp1.data > tmp2.data)
				tmp2 = tmp2.next;
			else
			{
				if(list == null)
				{
					list = new IntNode(tmp1.data, null);
					
					front = list;
				}
				else
				{
					list.next = new IntNode(tmp1.data, null);
					
					list = list.next;
				}
				
				tmp1 = tmp1.next;
				
				tmp2 = tmp2.next;
			}
		}
		
		return front;
	}
	
	public static void printList(StringNode x)
	{
		StringNode tmp = x;
		
		while(tmp != null)
		{
			System.out.print(tmp.data + " ");
			
			tmp = tmp.next;
		}
		
		System.out.println();
	}
}
