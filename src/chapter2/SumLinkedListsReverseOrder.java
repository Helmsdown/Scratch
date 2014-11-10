package chapter2;

/**
 * Created by russellb337 on 11/10/14.
 */
public class SumLinkedListsReverseOrder {

    private static Node<Integer> sum(Node<Integer> list1, Node<Integer> list2) {

        Node<Integer> list1Cursor = list1;
        Node<Integer> list2Cursor = list2;

        Node<Integer> resultHead = null;
        Node<Integer> resultCursor = null;

        int carry = 0;

        while(list1Cursor != null || list2Cursor != null || carry != 0) {

            int list1Data = list1Cursor != null ? list1Cursor.getData() : 0;
            int list2Data = list2Cursor != null ? list2Cursor.getData() : 0;

            int sum = list1Data + list2Data + carry;
            int digit = sum % 10;

            if(sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }

            if(resultCursor == null) {
                resultHead = new Node<>(digit, null);
                resultCursor = resultHead;
            } else {
                Node<Integer> newNode = new Node<>(digit, resultCursor);
                resultCursor = newNode;
            }


            if(list1Cursor != null) {
                list1Cursor = list1Cursor.getNext();
            }

            if(list2Cursor != null) {
                list2Cursor = list2Cursor.getNext();
            }

        }


        return resultHead;
    }


    public static void main(String[] args) {
        Node<Integer> list1 = createList(9);
        Node<Integer> list2 = createList(5);

        System.out.println("[List 1]");
        printList(list1);

        System.out.println("[List 2]");
        printList(list2);

        Node<Integer> sum = sum(list1, list2);

        System.out.println("[Sum]");
        printList(sum);

    }

    private static <T> void printList(Node<T> head) {
        Node<T> current = head;
        while(current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println();
    }

    private static Node<Integer> createList(int... n) {
        Node<Integer> head = new Node<>(n[0], null);
        Node<Integer> prev = head;
        for (int i = 1; i < n.length; i++) {
            Node<Integer> cur = new Node<>(n[i], prev);
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
