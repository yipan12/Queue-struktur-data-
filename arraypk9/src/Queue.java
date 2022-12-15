import static java.lang.System.out;

class Queue {
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node top, end;
    private int count;

    public Queue() {
        top = end = null;
        count = 0;
    }

    public void insert(Node n) {
        if(n != null) {
            if(top == null) {
                top = end = n;
            } else {
                end.setNext(n);
                end = n;
            }
            count++;
        }
    }

    public Node peek() {
        return top;
    }

    public Node remove() {
        Node k = top;
        if(top != null) {
            top = top.getNext();
            count--;
        }
        return k;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();

        for(int i = 0; i < 50; i++) {
            queue.insert(new Node(i));
        }

        out.println("Count: " + queue.getCount());

        Node k;
        while((k = queue.remove()) != null) {
            out.println(k.getData() + " ");
        }
    }
}