package poly;

import java.io.*;
import java.util.StringTokenizer;

/**
 * This class implements a term of a polynomial.
 * 
 * @author runb-cs112
 *
 */
class Term {
	/**
	 * Coefficient of term.
	 */
	public float coeff;
	
	/**
	 * Degree of term.
	 */
	public int degree;
	
	/**
	 * Initializes an instance with given coefficient and degree.
	 * 
	 * @param coeff Coefficient
	 * @param degree Degree
	 */
	public Term(float coeff, int degree) {
		this.coeff = coeff;
		this.degree = degree;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return other != null &&
		other instanceof Term &&
		coeff == ((Term)other).coeff &&
		degree == ((Term)other).degree;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (degree == 0) {
			return coeff + "";
		} else if (degree == 1) {
			return coeff + "x";
		} else {
			return coeff + "x^" + degree;
		}
	}
}

/**
 * This class implements a linked list node that contains a Term instance.
 * 
 * @author runb-cs112
 *
 */
class Node {
	
	/**
	 * Term instance. 
	 */
	Term term;
	
	/**
	 * Next node in linked list. 
	 */
	Node next;
	
	/**
	 * Initializes this node with a term with given coefficient and degree,
	 * pointing to the given next node.
	 * 
	 * @param coeff Coefficient of term
	 * @param degree Degree of term
	 * @param next Next node
	 */
	public Node(float coeff, int degree, Node next) {
		term = new Term(coeff, degree);
		this.next = next;
	}
}

/**
 * This class implements a polynomial.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {
	
	/**
	 * Pointer to the front of the linked list that stores the polynomial. 
	 */ 
	Node poly;
	
	/** 
	 * Initializes this polynomial to empty, i.e. there are no terms.
	 *
	 */
	public Polynomial() {
		poly = null;
	}
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param br BufferedReader from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 */
	public Polynomial(BufferedReader br) throws IOException {
		String line;
		StringTokenizer tokenizer;
		float coeff;
		int degree;
		
		poly = null;
		
		while ((line = br.readLine()) != null) {
			tokenizer = new StringTokenizer(line);
			coeff = Float.parseFloat(tokenizer.nextToken());
			degree = Integer.parseInt(tokenizer.nextToken());
			poly = new Node(coeff, degree, poly);
		}
	}
	
	
	/**
	 * Returns the polynomial obtained by adding the given polynomial p
	 * to this polynomial - DOES NOT change this polynomial
	 * 
	 * @param p Polynomial to be added
	 * @return A new polynomial which is the sum of this polynomial and p.
	 */
	public Polynomial add(Polynomial p) {
		Node other = p.poly;
		
		Node thisNode = this.poly;
		
		Polynomial newPoly = new Polynomial();
		
		if(thisNode == null && other == null)//if both polynomials are blank
			return newPoly;
		
		Node head = null;//to keep reference to head
		
		Node n = null;
		
		int sum = 0, c = 0;
		
		while(!(other == null && thisNode == null))//if both are not null
		{
			if((other != null && thisNode != null) && other.term.degree == thisNode.term.degree)
			{
				sum += (other.term.coeff + thisNode.term.coeff);//adding coefficients
				c = other.term.degree;//keeps track of degree
			}
			if(sum != 0)//if coefficient sum is not 0 add to list
			{
				if(n == null)//if there is no head present
				{
					n = new Node(sum, c, null);//adding new head
					head = n;//keeping reference to head
				}
				else
				{
					n.next = new Node(sum, c, null);
					
					n = n.next;
				}
				
				sum = 0;//setting coefficient sum back
				
				other = other.next;
				thisNode = thisNode.next;
			}
			else
			{
				if((other == null && thisNode != null) || (other != null && thisNode != null &&
						thisNode.term.degree < other.term.degree))
				{
					if(n == null)
					{
						n = new Node(thisNode.term.coeff, thisNode.term.degree, null);
						head = n;
					}
					else
					{
						n.next = new Node(thisNode.term.coeff, thisNode.term.degree, null);
						
						n = n.next;
					}
					
					thisNode = thisNode.next;
				}
				else if((thisNode == null && other != null) || (other != null && thisNode != null
					&&	other.term.degree < thisNode.term.degree))
				{
					if(n == null)
					{
						n = new Node(other.term.coeff, other.term.degree, null);
						head = n;
					}
					else
					{
						n.next = new Node(other.term.coeff, other.term.degree, null);
						
						n = n.next;
					}
					
					other = other.next;
				}
				else
				{
					other = other.next;
					thisNode = thisNode.next;
				}
				sum = 0;//setting coefficient sum back
			}
		}
		newPoly.poly = head;
		
		return newPoly;
	}
	
	/**
	 * Returns the polynomial obtained by multiplying the given polynomial p
	 * with this polynomial - DOES NOT change this polynomial
	 * 
	 * @param p Polynomial with which this polynomial is to be multiplied
	 * @return A new polynomial which is the product of this polynomial and p.
	 */
	public Polynomial multiply(Polynomial p) {
		Node other = p.poly, thisNode = this.poly;
		
		Polynomial sum = new Polynomial();
		
		if(thisNode == null && other == null)//if both polynomials are blank
			return sum;
		
		sum.poly = new Node(0, 0, null);
		
		while(thisNode != null)
		{
			Polynomial curr = new Polynomial();
			Node tmp = other, product = null, pHead = null;
			
			while(tmp != null)
			{
				if(product == null)
				{
					product = new Node((tmp.term.coeff * thisNode.term.coeff), 
							(tmp.term.degree + thisNode.term.degree), null);
					pHead = product;
				}
				else
				{
					product.next = new Node((tmp.term.coeff * thisNode.term.coeff), 
							(tmp.term.degree + thisNode.term.degree), null);
					product = product.next;
				}
				tmp = tmp.next;
			}
			curr.poly = pHead;
			if(curr.poly != null && sum.poly != null)
				sum = sum.add(curr);
			thisNode = thisNode.next;
		}
		
		return sum;
	}
	
	/**
	 * Evaluates this polynomial at the given value of x
	 * 
	 * @param x Value at which this polynomial is to be evaluated
	 * @return Value of this polynomial at x
	 */
	public float evaluate(float x) {
		Node head = poly;
		
		int sum = 0;
		
		while(head != null)
		{
			sum += Math.pow((int)x, head.term.degree) * head.term.coeff;
			
			head = head.next;
		}
		
		return (float)sum;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String retval;
		
		if (poly == null) {
			return "0";
		} else {
			retval = poly.term.toString();
			for (Node current = poly.next ;
			current != null ;
			current = current.next) {
				retval = current.term.toString() + " + " + retval;
			}
			return retval;
		}
	}
}
