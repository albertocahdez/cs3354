package com.company.IterableExample;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A custom collection class that implements Iterable for a list of Strings.
 */
public class StringCollection implements Iterable<String> {
    private String[] items;

    /**
     * Constructs a StringCollection with the given array of strings.
     *
     * @param items an array of strings to store in the collection
     */
    public StringCollection(String[] items) {
        this.items = items;
    }

    /**
     * Returns an iterator over elements of type {@code String}.
     *
     * @return an Iterator for the StringCollection
     */
    @Override
    public Iterator<String> iterator() {
        return new StringIterator();
    }

    /**
     * A private inner class that implements the Iterator interface for StringCollection.
     */
    private class StringIterator implements Iterator<String> {
        private int index = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * @return {@code true} if there are more elements to iterate over
         */
        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next String in the collection
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the collection.");
            }
            return items[index++];
        }
    }

    /**
     * Main method to demonstrate the usage of StringCollection and its iterator.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String[] data = {"apple", "banana", "cherry"};
        StringCollection collection = new StringCollection(data);

        for (String item : collection) {
            System.out.println(item);
        }
    }
}
