package linear;

public class ProblemSet4 {

	public static void main(String[] args) {
		Stack<Integer> x = new Stack<Integer>();
		
		x.push(4);
		
		x.push(7);
		
		x.push(3);
		
		System.out.println(size(x));
		
		System.out.println(x.pop());
		System.out.println(x.pop());
		System.out.println(x.pop());
		
		String s = "2 3 4 - * 5 /";
		
		System.out.println("E: " + postfixEvaluate(s));
	}
	public static <T> int size(Stack<T> s)
	{	
		Stack<T> x = new Stack<T>();
		
		int c = 0;
		
		while(!s.isEmpty())
		{
			x.push(s.pop());
			
			c++;
		}
		
		while(!x.isEmpty())
		{
			s.push(x.pop());
		}
		
		return c;
	}
	
	public static float postfixEvaluate(String expr) {
		Stack<Float> stack = new Stack<Float>();
		
		for(int i = 0;i < expr.length();i++)
		{
			char ch = expr.charAt(i);
			
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
			{
				Float second = stack.pop();
				
				Float first = stack.pop();
				
				switch(ch)
				{
				case '+':
					stack.push(first + second);
					break;
				case '-':
					stack.push(first - second);
					break;
				case '*':
					stack.push(first * second);
					break;
				case '/':
					stack.push(first / second);
					break;
				}
			}
			else if(ch != ' ')
				stack.push((float)Character.digit(ch, 10));
		}
		
		return stack.pop();
    }
}
