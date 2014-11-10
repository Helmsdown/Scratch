package chapter2;

/**
 * Created by russellb337 on 11/10/14.
 */
public class SumLinkedListsForwardOrder {

    private static Node<Integer> sum(Node<Integer> list1, Node<Integer> list2) {

        RecursionResult<Integer> recursionResult = recursiveSum(list1, list2);

        Node<Integer> finalResult = recursionResult.digit;

        if (recursionResult.carry != 0) {
            Node<Integer> carryNode = new Node<>(recursionResult.carry, null);
            carryNode.setNext(finalResult);
            finalResult = carryNode;
        }

        return finalResult;
    }

    private static RecursionResult<Integer> recursiveSum(Node<Integer> list1, Node<Integer> list2) {

        boolean finalNodeOfList1 = list1 == null || (list1.getNext() == null);
        boolean finalNodeOfList2 = list2 == null || (list2.getNext() == null);

        int list1Data = list1 != null ? list1.getData() : 0;
        int list2Data = list2 != null ? list2.getData() : 0;

        //base case
        if (finalNodeOfList1 && finalNodeOfList2) {
            int sum = list1Data + list2Data;
            int digit = sum % 10;

            Node<Integer> node = new Node<>(digit, null);
            int carry = computeCarry(sum);

            return new RecursionResult<>(node, carry);
        }

        RecursionResult<Integer> recursionResult = recursiveSum(
                list1 != null ? list1.getNext() : null,
                list2 != null ? list2.getNext() : null);

        int sum = list1Data + list2Data + recursionResult.carry;
        int digit = sum % 10;

        Node<Integer> node = new Node<>(digit, null);
        node.setNext(recursionResult.digit);
        int carry = computeCarry(sum);

        return new RecursionResult<>(node, carry);
    }

    private static int computeCarry(int sum) {
        return sum >= 10 ? sum / 10 : 0;
    }


    public static void main(String[] args) {
        Node<Integer> list1 = createList(9, 8, 7);
        Node<Integer> list2 = createList(2, 3, 4);

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
        while (current != null) {
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

    public static class RecursionResult<T> {

        public final int carry;
        public final Node<T> digit;

        public RecursionResult(Node<T> digit, int carry) {
            this.carry = carry;
            this.digit = digit;
        }
    }


    public static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> prev) {
            this.data = data;

            if (prev != null) {
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
    }
}
