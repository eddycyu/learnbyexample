package dev.eddycyu.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * How to implement <code>Comparable</code> with <code>Comparator</code> in
 * Java for multi-field comparison.
 * <p>
 * This implementation using <code>Comparator</code> is more concise but
 * slightly slower than the implementation that does not use <code>Comparator</code>.
 *
 * @see dev.eddycyu.comparison.ComparableBlock
 */
public class CompareBlock implements Comparable<CompareBlock> {

    private String name;
    private int weight;
    private int size;

    // multi-field comparator: first lightest block, then smallest block
    private static final Comparator<CompareBlock> COMPARATOR =
            comparingInt((CompareBlock block) -> block.weight)
                    .thenComparingInt(block -> block.size);

    public CompareBlock(String name, int weight, int size) {
        this.name = name;
        this.weight = weight;
        this.size = size;
    }

    // add other constructors, getters, setters, etc...

    @Override
    public int compareTo(CompareBlock o) {
        return COMPARATOR.compare(this, o);
    }

    public static void main(String[] args) {
        final CompareBlock block1 = new CompareBlock("block1", 10, 2);
        final CompareBlock block2 = new CompareBlock("block2", 20, 1);
        final CompareBlock block3 = new CompareBlock("block3", 10, 1);
        final CompareBlock block4 = new CompareBlock("block4", 20, 2);
        final List<CompareBlock> list = new ArrayList<>();
        list.add(block1);
        list.add(block2);
        list.add(block3);
        list.add(block4);
        Collections.sort(list);
        System.out.println("blocks sorted by lightest, then smallest:");
        for (CompareBlock block : list) {
            System.out.println(block.name + " [weight: " + block.weight + "][size: " + block.size + "]");
        }
    }
}
