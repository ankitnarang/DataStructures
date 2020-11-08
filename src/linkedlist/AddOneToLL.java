package linkedlist;

import org.w3c.dom.ls.LSException;

public class AddOneToLL {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode addOneUtil(ListNode head){
        ListNode res = head;
        ListNode temp  = null, prev = null;
        int carry = 1;
        int sum = 0;

        while (head != null) {
            sum = carry + head.data;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            head.data = sum;
            if(carry == 0){
                break;
            }
            temp = head;
            head = head.next;
        }

        if(carry > 0){
            temp.next = new ListNode(carry);
        }

        return res;
    }

    private static ListNode addOne(ListNode head){
        ListNode res;
        head = reverse(head);
        head = addOneUtil(head);
        head = reverse(head);
        return head;
    }

    static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data +  " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);

        System.out.println("List is ");
        printList(head);
        head = addOne(head);
        System.out.println();
        System.out.println("After adding one, list is ");
        printList(head);
    }


}
