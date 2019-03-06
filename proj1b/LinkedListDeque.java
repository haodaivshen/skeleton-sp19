public class LinkedListDeque<Item> implements Deque<Item> {
    private class Node {
        public Item data_;
        public Node next_;
        public Node prev_;

        public Node(Node other) {
            data_ = other.data_;
            prev_ = other.prev_;
            next_ = other.next_;
        }

        public Node(Item data, Node prev, Node next) {
            data_ = data;
            prev_ = prev;
            next_ = next;
        }
    }

    private Node sentinel_;
    private int size_;


    public LinkedListDeque() {
        sentinel_ = new Node(null, null, null);
        size_ = 0;
    }

    public LinkedListDeque(LinkedListDeque<Item> other) {
        sentinel_ = new Node(null, null, null);
        size_ = other.size_;

        for (int i = 0; i < other.size_; i++) {
            addFirst(other.get(i));
        }
    }
    /**
     * Adds an item of type Item to the front of the deque.
     */
    @Override
    public void addFirst(Item data) {
        Node temp = sentinel_.next_;

        if (sentinel_.next_ == null) {
            sentinel_.next_ = new Node(data, null, null);
            sentinel_.prev_ = sentinel_.next_;
        } else {
            sentinel_.next_ = new Node(data, null, temp);
            temp.prev_ = sentinel_.next_;

        }

        size_ ++;
    }

    /**
     * Adds an item of type Item to the back of the deque.
     */
    @Override
    public void addLast(Item data) {
        Node temp = sentinel_.prev_;

        if (sentinel_.prev_ == null) {
            sentinel_.prev_ = new Node(data, null, null);
            sentinel_.next_ = sentinel_.prev_;
        } else {
            sentinel_.prev_ = new Node(data, temp, null);
            temp.next_ = sentinel_.prev_;

        }

        size_ ++;
    }


    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size_;
    }

    /**
     * Prints the items in the deque from first to last, separated by Space.
     * Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
        Node temp = sentinel_.next_;
        while (temp != null) {
            System.out.print(temp.data_.toString());
            System.out.print(" ");

            temp = temp.next_;
        }

        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. if no such
     * item exists, return null.
     */
    @Override
    public Item removeFirst() {
        Node first = sentinel_.next_;
        if (first != null) {
            size_--;
            if (sentinel_.next_.next_ != null) {
                sentinel_.next_.next_.prev_ = sentinel_;
                sentinel_.next_ = sentinel_.next_.next_;
            }
            return first.data_;
        } else {
            return null;
        }
    }

    /**
     * Removes and returns the item at the back of the deque. if no such
     * item exists, return null.
     */
    @Override
    public Item removeLast() {
        Node last = sentinel_.prev_;
        if (last != null) {
            size_ --;
            if (sentinel_.prev_.prev_ != null) {

                sentinel_.prev_.prev_.next_ = sentinel_;
                sentinel_.prev_ = sentinel_.prev_.prev_;
            }
            return last.data_;
        } else {
            return null;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the
     * next item, and so forth. If no such item exists, returns null.
     * Must not alter the deque!
     */
    @Override
    public Item get(int index) {
        Node t = sentinel_.next_;

        while (index != 0) {
            t = t.next_;
            index --;
        }
        return t.data_;
    }

    public Item getRecursive(int index) {
        return getRecursive_(index, sentinel_.next_);
    }

    private Item getRecursive_(int index, Node item) {
        if (index != 0) {
            return getRecursive_(index - 1, item.next_);
        } else {
            return item.data_;
        }
    }
}
