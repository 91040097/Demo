package linear;

public class IntNode {
    public int data;
    public IntNode next;
    
    public IntNode(int data) {
        this.data = data; this.next = null;
    }
    
    public IntNode(int data, IntNode next) {
        this.data = data; this.next = next;
    }
    public String toString() {
        return data + "";
 }
}