package chapter2;

import java.util.Random;

/**
 * Created by russellb337 on 11/7/14.
 *
 * 2.4: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x
 */
public class LinkedListPartition {

    public static void main(String[] args) {
        Node<Integer> list = createList(10);

        printList(list);

        list = partitionList(list, 5);

        printList(list);
    }

    private static <T extends Comparable> Node<T> partitionList(Node<T> head, T partition) {

        //list of size 0 or 1 are a no op
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> cursor = head.getNext();
        Node<T> newCenter = head;
        head.setNext(null);
        head.setPrev(null);


        while (cursor != null) {
            Node<T> current = cursor;
            cursor = cursor.getNext();
            if (current.getData().compareTo(partition) < 0) {
                //this goes before the new center
                current.setNext(newCenter);
                current.setPrev(newCenter.getPrev());
                if(newCenter.getPrev() != null) {
                    newCenter.getPrev().setNext(current);
                }
                newCenter.setPrev(current);
            } else {
                //this goes after the new center
                current.setPrev(newCenter);
                current.setNext(newCenter.getNext());
                if(newCenter.getNext() != null) {
                    newCenter.getNext().setPrev(current);
                }
                newCenter.setNext(current);
            }
        }

        Node<T> newHead = newCenter;
        while(newHead.getPrev() != null) {
            newHead = newHead.getPrev();
        }

        return newHead;
    }

    private static <T> void printList(Node<T> head) {
        Node<T> current = head;
        while(current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println();
    }

    private static Node<Integer> createList(int n) {
        Random r = new Random(System.currentTimeMillis());
        Node<Integer> head = new Node<>(r.nextInt(10), null);
        Node<Integer> prev = head;

        for (int i = 2; i < n; i++) {
            Node<Integer> cur = new Node<>(r.nextInt(10), prev);
            prev = cur;
        }
        return head;
    }

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

        public void setData(T data) {
            this.data = data;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

}
