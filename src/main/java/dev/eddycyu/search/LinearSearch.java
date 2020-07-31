package dev.eddycyu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Linear (or sequential) search.
 * <p>
 * Given an array of elements, search for a given target element in the array.
 * <p>
 * https://en.wikipedia.org/wiki/Linear_search
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @see BinarySearchIteration
 * @see BinarySearchRecursion
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static int search(String[] data, String target) {
        // search sequentially through the data for the target
        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(target) == 0) {
                return i;
            }
        }
        // target not found
        return -1;
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
