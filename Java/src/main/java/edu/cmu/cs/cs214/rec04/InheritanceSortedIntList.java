package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 */
public class InheritanceSortedIntList extends SortedIntList {

    private int totalAdded = 0;

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
        return super.add(value);
    }

    /**
     * Attempts to add all elements from another IntegerList.
     * Increments the total-added counter by the number of attempted insertions.
     */
    @Override
    public boolean addAll(IntegerList other) {
        totalAdded += other.size();
        return super.addAll(other);
    }
}
