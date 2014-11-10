package chapter2;

/**
 * Created by russellb337 on 11/7/14.
 *
 * Problem: 2.1, Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
 */
public class DeleteANode {

    private static <T> void deleteNode(Node<T> node) {
        Node<T> next = node.getNext();
        node.setData(next.getData()); //steal next's data
        node.setNext(next.getNext()); //point to next.next
    }

    public static void main(String[] args) {

        Node<String> list = createList(10);

        printList(list);

        deleteNode(list.getNext().getNext().getNext()); //should delete 4

        printList(list);


    }

    private static <T> void printList(Node<T> head) {
        Node<T> current = head;
        while(current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println();
    }

    private static Node<String> createList(int n) {
        Node<String> head = new Node<>("1", null);
        Node<String> prev = head;
        for (int i = 2; i < n; i++) {
            Node<String> cur = new Node<>(""+i, prev);
            prev = cur;
        }

        return head;
    }

    public static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> prev) {
            this.data = data;

            if(prev != null) {
                prev.setNext(this);
            }
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        protected void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
