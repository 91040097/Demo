package linear;

public class BSTN<T extends Comparable<T>> {
    BSTNode<T> root;
    int size;
    
    public BSTN()
    {
    	root = null;
    }
    
    public BSTN(BSTNode<T> r)
    {
    	root = r;
    }
    
    public void insert(T target) 
    throws IllegalArgumentException {

            BSTNode ptr=root, prev=null;
            int c=0;
            while (ptr != null) {
                    c = target.compareTo((T) ptr.data);
                    if (c == 0) {
                            throw new IllegalArgumentException("Duplicate key");
                    }
                    prev = ptr;
                    ptr = c < 0 ? ptr.left : ptr.right;
            }
            BSTNode tmp = new BSTNode(target);
            size++;
            if (root == null) {
                    root = tmp;
                    return;
            }
            if (c < 0) {
                    prev.left = tmp;
            } else {
                    prev.right = tmp;
            }
}
    
    public void insertR(T target)
    {
    	BSTNode tmp = root;
    	
    	insertR(target, null, tmp);
    }
    
    private void insertR(T target, BSTNode prev, BSTNode tmp) throws IllegalArgumentException
    {
    	if(tmp == null && prev != null)
    	{
    		if(target.compareTo((T) prev.data) < 0)
    			prev.left = new BSTNode(target);
    		else if(target.compareTo((T) prev.data) > 0)
    			prev.right = new BSTNode(target);
    		else
    			throw new IllegalArgumentException();
    	}
    	else
    	{
    		if(tmp != null && target.compareTo((T) tmp.data) < 0)
    			insertR(target, tmp, tmp.left);
    		else if(tmp != null && target.compareTo((T) tmp.data) > 0)
    			insertR(target, tmp, tmp.right);
    		else
    			throw new IllegalArgumentException();
    	}
    }
    
    public void delete(T target)
    {
    	BSTNode<T> x = root, p =null;
    	
    	while(x != null)
    	{
    		int c = target.compareTo(x.data);
    		
    		if(c == 0)
    			break;
    		
    		p = x;
    		
    		x = c < 0 ? x.left : x.right;
    	}
    	
    	size--;
    	
    	//x has 2 children
    	if(x.left != null && x.right != null)
    	{
    		//find inorder predecessor of x
    		
    		BSTNode<T> y = x.left;
    		p = x;
    		while(y.right != null)
    		{
    			p = y;
    			y = y.right;
    		}
    		//copy y's data in to
    		x.data = y.data;
    		//set x to y and fall through to leaf/1 child
    		x = y;
    	}
    	
    	//leaf and 1 child cases
    	if(p == null)
    	{
    		root = x.left != null ? x.left : x.right;
    		return;
    	}
    	
    	BSTNode tmp = x.left != null ? x.left :x.right;
    	
    	if(x == p.right)
    		p.right = tmp;
    	else
    		p.left = tmp;
    }
    
    public void inOrderTraversal()
    {
    	inOrderTraversal(root);
    }
    
    private void inOrderTraversal(BSTNode<T> r)
    {
    	if(r == null)
    		return;
    	
    	inOrderTraversal(r.left);
    	
    	System.out.println(r.data);
    	
    	inOrderTraversal(r.right);
    	
    }
}
