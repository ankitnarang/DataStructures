package linkedlist;

public class IntersectionPointLL {
	
	@SuppressWarnings("unused")
	private static int getIntersectionPoint(LLNode head1,LLNode head2) {
		LLNode curr1 = head1;
		LLNode curr2 = head2;
		
		while(curr1 != null && curr2 != null) {
			if(curr1 == curr2)
				break;
			
			if(curr1 == null) {
				curr1 = head2;
			}
			else {
				curr1 = curr1.next;
			}
			
			if(curr2 == null) {
				curr2 = head1;
			}
			else {
				curr2 = curr2.next;
			}
		}
		
		return curr1.data;
	}
	
	private static int getNode(LLNode head1,LLNode head2) {
		int count1 = getCount(head1);
		int count2 = getCount(head2);
		int diff = -1;
		if(count1 > count2) {
			diff = count1 - count2;
			return getIntersectionNode(diff,head1,head2);
		} else {
			diff = count2 - count1;
			return getIntersectionNode(diff,head2,head1);
		}
	}
	
	
	
	private static int getIntersectionNode(int diff, LLNode head1, LLNode head2) {
		int i;
		LLNode curr1 = head1;
		LLNode curr2 = head2;
		for(i = 0 ; i < diff; i++) {
			if(curr1 == null)
				return -1;
			curr1 = curr1.next;
		}
		while(curr1 != null && curr2 != null) {
			if(curr1.data == curr2.data) {
				return curr1.data;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return -1;
	}

	private static int getCount(LLNode head) {
		// TODO Auto-generated method stub
		LLNode curr = head;
		int length = 0;
		while(curr != null) {
			curr = curr.next;
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		LLNode newNode; 
	    LLNode head1 = new LLNode(3);
	    LLNode head2 = new LLNode(10);
	    newNode = new LLNode(15);
	    head2.next = newNode;
	    newNode = new LLNode(30);
	    head2.next.next = newNode;
	    newNode = new LLNode(6);
	    head1.next = newNode;
	    newNode = new LLNode(9);
	    head1.next.next = newNode;
	    newNode = new LLNode(15);
	    head1.next.next.next = newNode;
	    newNode = new LLNode(30);
	    head1.next.next.next.next = newNode;
	    
	    System.out.println("Intersection point is : " + getIntersectionPoint(head1, head2));
	    System.out.println("Intersection point is : " + getNode(head1, head2));
	}

}
class LLNode{
	int data;
	LLNode next;
	public LLNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}
}
