public class ArrayDeque<Item> implements Deque<Item> {

    private Item[] items_;
    private static int default_capacity = 8;
    private int nextFirst_;
    private int nextLast_;
    private int size_;
    private int capacity_;


    public ArrayDeque() {
        items_ = (Item[]) new Object[default_capacity];
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
        Item[] newItems = (Item[]) new Object[capacity_*2];
        System.arraycopy(items_, 0, newItems, 0, capacity_);
        capacity_ *= 2;
    }

    /**
     * Adds an item of type Item to the front of the deque.
     */
    @Override
    public void addFirst(Item item) {
        items_[nextFirst_] = item;
        size_++;
        nextFirst_ = subNext(nextFirst_);

        if (size_ == capacity_) {
            expand();
        }
    }

    /**
     * Adds an item of type Item to the back of the deque.
     */
    @Override
    public void addLast(Item item) {
        items_[nextLast_] = item;
        size_++;
        nextLast_ = addNext(nextLast_);

        if (size_ == capacity_) {
            expand();
        }
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
    @Override
    public Item removeFirst() {
        Item item = items_[nextFirst_];
        nextFirst_ = addNext(nextFirst_);
        size_ --;
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque. if no such
     * item exists, return null.
     */
    public Item removeLast() {
        Item item = items_[nextLast_];
        nextLast_ = subNext(nextLast_);
        size_--;
        return item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the
     * next item, and so forth. If no such item exists, returns null.
     * Must not alter the deque!
     */
    @Override
    public Item get(int index) {
        Item item;

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
