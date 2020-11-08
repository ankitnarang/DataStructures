package linkedlist;

public class MergeSortedLL {

    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode llist1 = new ListNode(1);
        llist1.next = new ListNode(2);
        llist1.next.next = new ListNode(4);

        ListNode temp = llist1;
        System.out.println("List 1");
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("NULL");

        System.out.println();
        System.out.println("List2");
        ListNode llist2 = new ListNode(1);
        llist2.next = new ListNode(3);
        llist2.next.next = new ListNode(4);

        temp = llist2;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("NULL");

        ListNode list = mergeLists(llist1,llist2);
        System.out.println();
        System.out.println("Merged List");
        temp = list;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("NULL");

    }

    private static ListNode mergeLists(ListNode llist1, ListNode llist2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (llist1 != null && llist2 != null){
            if(llist1.val < llist2.val){
                dummy.next = llist1;
                llist1 = llist1.next;
            } else {
                dummy.next = llist2;
                llist2 = llist2.next;
            }
            dummy = dummy.next;
        }

        if(llist1 != null){
            dummy.next = llist1;
        } else {
            dummy.next = llist2;
        }

        return head.next;
    }
}
