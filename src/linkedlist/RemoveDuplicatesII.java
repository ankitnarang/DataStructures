package linkedlist;

public class RemoveDuplicatesII {
    public static void main(String[] args) {
        RemoveDuplicatesII list = new RemoveDuplicatesII();
        list.push(5);
        list.push(4);
        list.push(4);
        list.push(3);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.println("List before removal of duplicates");
        list.printList();

        list.removeAllDuplicates();

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

    void removeAllDuplicates() {
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (curr != null) {
            while (curr.next != null && pre.next.data == curr.next.data) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        head = dummy.next;
    }

}
