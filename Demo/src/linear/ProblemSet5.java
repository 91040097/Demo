package linear;

public class ProblemSet5 {

	public static void main(String[] args) {
		Queue<Integer> x = new Queue<Integer>();
		
		x.enqueue(5);
		
		x.enqueue(4);
		
		x.enqueue(7);
		
		System.out.println(peek(x));
		
		System.out.println(x.dequeue());
		
		System.out.println(x.dequeue());
		
		System.out.println(x.dequeue());
	}
	
	public static <T> T peek(Queue<T> q)
	{
		Queue<T> tmp = new Queue<T>();
		
		T val = q.dequeue();
		
		tmp.enqueue(val);
		
		while(!(q.isEmpty()))
		{
			tmp.enqueue(q.dequeue());
		}
		
		while(!(tmp.isEmpty()))
		{
			q.enqueue(tmp.dequeue());
		}
		
		return val;
	}
	public static<T> int size(Queue<T> q)
	{
		for(int i = 0;i < q.size();i++)
		{
			
		}
		return -1;
	}
}
