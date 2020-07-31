package dev.eddycyu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Binary search (recursive implementation).
 * <p>
 * Given a sorted array of elements, search for a given target element in the array.
 * <p>
 * https://en.wikipedia.org/wiki/Binary_search_algorithm
 * <p>
 * Note: Binary search requires that the data to be searched is already sorted
 * in ascending order.
 * <p>
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 *
 * @see BinarySearchIteration
 */
public class BinarySearchRecursion {

    private BinarySearchRecursion() {
    }

    public static int search(String[] data, String target) {
        return search(data, target, 0, data.length);
    }

    private static int search(String[] data, String target, int lo, int hi) {
        if (hi <= lo) {
            // target not found
            return -1;
        }
        final int mid = lo + (hi - lo) / 2;
        final int result = data[mid].compareTo(target);
        if (result > 0) {
            // mid is larger than target; check lower half
            return search(data, target, lo, mid);
        } else if (result < 0) {
            // mid is smaller than target; check upper half
            return search(data, target, mid + 1, hi);
        } else {
            // found target at mid point
            return mid;
        }
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

            // sort the data in the array
            Arrays.sort(strings);

            // pick random target from data
            final String target = strings[(int) (Math.random() * strings.length)];

            // search for target
            final int result = search(strings, target);
            if (result != -1) {
                System.out.println("Found target [" + target + "] at index [" + result + "].");
            } else {
                System.out.println("Unable to find target [" + target + "].");
            }
        }
    }
}
