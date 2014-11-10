package chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by russellb337 on 11/6/14.
 */
public class RemoveDuplicatesFromLinkedList {

    private static <T extends Comparable> void removeDuplicates(Node<T> head) {

        //list of size 0 or 1 are a no op
        if(head == null || head.getNext() == null) {
            return;
        }

        Set<T> uniqueValues = new HashSet<>(); //store unique values

        uniqueValues.add(head.getData()); //store the first node's value in the set
        Node<T> current = head.getNext(); //start from the second node

        while(current != null) {
            T data = current.getData();
            if(uniqueValues.contains(data)) {
                //this is a duplicate, point prev.next to current.next
                current.getPrev().setNext(current.getNext());
            } else {
                uniqueValues.add(data);
            }
            current = current.getNext();
        }

    }

    private static <T extends Comparable> void removeDuplicatesWithoutDataStructure(Node<T> head) {
        //list of size 0 or 1 are a no op
        if(head == null || head.getNext() == null) {
            return;
        }

        //start on the first node
        Node<T> current = head;
        while(current != null) {

            Node<T> runner = current.getNext();
            while(runner != null) {
                if(current.getData().compareTo(runner.getData()) == 0) {
                    runner.getPrev().setNext(runner.getNext());
                }
                runner = runner.getNext();
            }

            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        withDataStructure();
        withoutDataStructure();
    }

    private static void withDataStructure() {
        Node<String> head = createList();

        removeDuplicates(head);
        printList(head);
    }

    private static void withoutDataStructure() {
        Node<String> head = createList();

        removeDuplicatesWithoutDataStructure(head);
        printList(head);
    }

    private static <T> void printList(Node<T> head) {
        Node<T> current = head;
        while(current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println();
    }

    private static Node<String> createList() {
        Node<String> head = new Node<>("x", null);
        Node<String> second = new Node<>("y", head);
        Node<String> third = new Node<>("x", second);
        Node<String> fourth = new Node<>("z", third);
        Node<String> fifth = new Node<>("x", fourth);
        return head;
    }


    /**
     * Created by russellb337 on 11/6/14.
     */
    public static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> prev) {
            this.data = data;
            this.prev = prev;

            if(this.prev != null)
                this.prev.setNext(this);
        }

        protected void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }
    }
}
