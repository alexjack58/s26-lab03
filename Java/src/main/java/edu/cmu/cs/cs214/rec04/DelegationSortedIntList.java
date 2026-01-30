package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 */
public class DelegationSortedIntList implements IntegerList {

    private final SortedIntList inner;
    private int totalAdded = 0;

    /**
     * Constructs an empty DelegationSortedIntList.
     */
    public DelegationSortedIntList() {
        inner = new SortedIntList();
    }

    /**
     * Returns the total number of attempted element insertions.
     */
    public int getTotalAdded() {
        return totalAdded;
    }

    /**
     * Attempts to add a single element to the list.
     * Increments the total-added counter regardless of success.
     */
    @Override
    public boolean add(int value) {
        totalAdded += 1;
        return inner.add(value);
    }

    /**
     * Attempts to add all elements from another IntegerList.
     * Increments the total-added counter by the number of attempted insertions.
     */
    @Override
    public boolean addAll(IntegerList other) {
        totalAdded += other.size();
        return inner.addAll(other);
    }

    /**
     * Returns the element at the given index.
     */
    @Override
    public int get(int index) {
        return inner.get(index);
    }

    /**
     * Attempts to remove a single value from the list.
     */
    @Override
    public boolean remove(int value) {
        return inner.remove(value);
    }

    /**
     * Attempts to remove all values from this list that appear in the other list.
     */
    @Override
    public boolean removeAll(IntegerList other) {
        return inner.removeAll(other);
    }

    /**
     * Returns the current number of elements in the list.
     */
    @Override
    public int size() {
        return inner.size();
    }
}
