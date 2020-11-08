package linkedlist;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        list.push(20);
        list.push(13);
        list.push(13);
        list.push(11);
        list.push(11);
        list.push(11);

        System.out.println("List before removal of duplicates");
        list.printList();

        list.removeDuplicates();

        System.out.println("List after removal of elements");
        list.printList();

    }

    ListNode head;  // head of list

    /* Linked list Node*/
    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        ListNode newNode = new ListNode(new_data);
        newNode.next = head;
        head = newNode;
    }

    /* Function to print linked list */
    void printList() {
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void removeDuplicates() {
        ListNode curr = head;
        while (curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

}
