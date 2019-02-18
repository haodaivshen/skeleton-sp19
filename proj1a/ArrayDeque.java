public class ArrayDeque<T> {

    private T[] items_;
    private static int default_capacity = 8;
    private int nextFirst_;
    private int nextLast_;
    private int size_;
    private int capacity_;


    public ArrayDeque() {
        items_ = (T[]) new Object[default_capacity];
        nextFirst_ = 0;
        nextLast_ = 1;
        capacity_ = default_capacity;
    }

    public ArrayDeque(ArrayDeque other) {
        nextFirst_ = other.nextFirst_;
        nextLast_ = other.nextLast_;
        size_ = other.size_;
        capacity_ = other.capacity_;

        System.arraycopy(other.items_, 0, items_, 0, capacity_);
    }

    private int addNext(int pos) {
        return (pos + 1) % capacity_;
    }

    private int subNext(int pos) {
        return (pos - 1 + capacity_) % capacity_;
    }

    private void expand() {
        T[] newItems = (T[]) new Object[capacity_*2];
        System.arraycopy(items_, 0, newItems, 0, capacity_);
        capacity_ *= 2;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        items_[nextFirst_] = item;
        size_++;
        nextFirst_ = subNext(nextFirst_);

        if (size_ == capacity_) {
            expand();
        }
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        items_[nextLast_] = item;
        size_++;
        nextLast_ = addNext(nextLast_);

        if (size_ == capacity_) {
            expand();
        }
    }

    /**
     * Return true if dqeue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size_ == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size_;
    }

    /**
     * Prints the items in the deque from first to last, separated by Space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        for (int i = addNext(nextFirst_); i < nextLast_; i = addNext(i)) {
            System.out.print(items_[i].toString());
            System.out.print(" ");
        }

        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. if no such
     * item exists, return null.
     */
    public T removeFirst() {
        T item = items_[nextFirst_];
        nextFirst_ = addNext(nextFirst_);
        size_ --;
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque. if no such
     * item exists, return null.
     */
    public T removeLast() {
        T item = items_[nextLast_];
        nextLast_ = subNext(nextLast_);
        size_--;
        return item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the
     * next item, and so forth. If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        T item;

        if (index < size_) {
            int i = addNext(nextFirst_);
            while (i < nextLast_ + index) {
                i = addNext(i);
            }

            item = items_[i];
        } else {
            item = null;
        }

        return item;
    }
}
