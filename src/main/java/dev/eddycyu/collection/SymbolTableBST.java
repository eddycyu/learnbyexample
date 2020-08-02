package dev.eddycyu.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Symbol table using binary search tree (BST).
 * <p>
 * Given an unsorted array of elements, output each element in sorted
 * (ascending) order along with the frequency that the element repeats in the
 * array.
 * <p>
 * https://en.wikipedia.org/wiki/Symbol_table
 * https://en.wikipedia.org/wiki/Binary_search_tree
 * <p>
 * Best case is when keys come in random order which results in a roughly balanced tree.
 * Worst case is when the keys come in sorted order which results in a linked list.
 * <p>
 * Time Complexity: O(n log n)
 * <p>
 * Note: To implement a symbol table using a left-leaning red-black (LLRB) tree
 * (e.g. self-balancing binary search tree), see:
 * <p>
 * https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
 * https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
 * https://en.wikipedia.org/wiki/Left-leaning_red%E2%80%93black_tree
 */
public class SymbolTableBST<Key extends Comparable<Key>, Value> {

    private Node root = null;

    private class Node {
        private final Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            super();
            this.key = key;
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        final int result = key.compareTo(node.key);
        if (result < 0) {
            // key value is less than node's key value; check left node
            node.left = put(node.left, key, value);
        } else if (result > 0) {
            // key value is greater than node's key value; check right node
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        while (node != null) {
            final int result = key.compareTo(node.key);
            if (result < 0) {
                // key value is less than node's key value; check left node
                node = node.left;
            } else if (result > 0) {
                // key value is greater than node's key value; check right node
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        final LinkedList<Key> queue = new LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    public void inorder(Node node, List<Key> queue) {
        if (node == null) {
            return;
        }
        inorder(node.left, queue);
        queue.add(node.key);
        inorder(node.right, queue);
    }

    public static void main(String[] args) throws IOException {
        try (final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            // read data from standard input
            String line;
            final List<String> data = new ArrayList<>();
            while (true) {
                line = bf.readLine();
                if ((line == null) || line.isEmpty()) {
                    break;
                }
                data.add(line);
            }

            // terminate if no data was read
            if (data.isEmpty()) {
                return;
            }

            // convert list to array
            final String[] strings = data.toArray(new String[0]);

            // add key-value pairs to symbol table and keep track of frequency
            final SymbolTableBST<String, Integer> freq = new SymbolTableBST<>();
            for (String key : strings) {
                if (freq.contains(key)) {
                    freq.put(key, freq.get(key) + 1);
                } else {
                    freq.put(key, 1);
                }
            }

            // output frequency
            for (String key : freq.keys()) {
                System.out.printf("%s : %d\n", key, freq.get(key));
            }
        }
    }
}
