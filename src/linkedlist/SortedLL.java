package linkedlist;

import java.util.LinkedList;

/*
    Insert in Sorted Linked List
 */
public class SortedLL {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    Node head;

    private void sortedInsert(Node newNode){
        Node curr = head;
        if(head == null || head.data >= newNode.data){
            newNode.next = head;
            head = newNode;
        } else {
            while (curr.next != null && curr.next.data < newNode.data){
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    private Node addNewNode(int data){
        Node newNode = new Node(data);
        return newNode;
    }

    private void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args){
        SortedLL list = new SortedLL();
        Node newNode;
        newNode = list.addNewNode(5);
        list.sortedInsert(newNode);
        newNode = list.addNewNode(10);
        list.sortedInsert(newNode);
        newNode = list.addNewNode(7);
        list.sortedInsert(newNode);
        System.out.println();
        System.out.println("After inserting 3 elements, LinkedList ");
        list.printList();
        newNode = list.addNewNode(3);
        list.sortedInsert(newNode);
        newNode = list.addNewNode(9);
        list.sortedInsert(newNode);
        System.out.println("\nAfter inserting 2 more elements, LinkedList ");
        list.printList();
    }

}
