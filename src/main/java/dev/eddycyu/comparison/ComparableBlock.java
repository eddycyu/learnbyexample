package dev.eddycyu.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * How to implement <code>Comparable</code> in Java for multi-field
 * comparison.
 */
public class ComparableBlock implements Comparable<ComparableBlock> {

    private String name;
    private int weight;
    private int size;

    public ComparableBlock(String name, int weight, int size) {
        this.name = name;
        this.weight = weight;
        this.size = size;
    }

    // add other constructors, getters, setters, etc...

    @Override
    public int compareTo(ComparableBlock o) {
        // multi-field comparison: first lightest block, then smallest block
        int result = Integer.compare(weight, o.weight);
        if (result == 0) {
            result = Integer.compare(size, o.size);
        }
        return result;
    }

    public static void main(String[] args) {
        final ComparableBlock block1 = new ComparableBlock("block1", 10, 2);
        final ComparableBlock block2 = new ComparableBlock("block2", 20, 1);
        final ComparableBlock block3 = new ComparableBlock("block3", 10, 1);
        final ComparableBlock block4 = new ComparableBlock("block4", 20, 2);
        final List<ComparableBlock> list = new ArrayList<>();
        list.add(block1);
        list.add(block2);
        list.add(block3);
        list.add(block4);
        Collections.sort(list);
        System.out.println("blocks sorted by lightest, then smallest:");
        for (ComparableBlock block : list) {
            System.out.println(block.name + " [weight: " + block.weight + "][size: " + block.size + "]");
        }
    }
}
