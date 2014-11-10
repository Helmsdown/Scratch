package chapter2;

/**
 * Created by russellb337 on 11/7/14.
 */
public class KthToLastElement {
    private static <T> Node<T> findKthToLastElement(Node<T> head, int k) {

        Node<T> p1 = head;
        Node<T> p2 = head;

        for (int i = 0; i < k - 1; i++) {
            p2 = p2.getNext();
        }

        while(p2.getNext() != null) {
            p2 = p2.getNext();
            p1 = p1.getNext();
        }
        return p1;
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

    public static void main(String[] args) {
        Node<String> list = createList(100);
        System.out.println(findKthToLastElement(list, 10));
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
