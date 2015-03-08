package linear;

public class ProblemSet6 {

	public static void main(String[] args) {
		BSTNode x = new BSTNode(5);
		
		x.left = new BSTNode(4);
		
		x.right = new BSTNode(6);
		
		BSTN a = new BSTN(x);
		
		System.out.println(x);
		
		System.out.println(x.left);
		
		System.out.println(x.right);
		
		a.insertR(5);
		//a.delete(6);
		
		System.out.println();
		
		System.out.println(x);
		
		System.out.println(x.left);
		
		//System.out.println(x.left.left);
		
		System.out.println(x.right);
		
		System.out.println(x.right.right);
	}
}
