package dev.eddycyu.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Insertion sort.
 * <p>
 * Given an unsorted array of strings, sort the strings in ascending order.
 * <p>
 * https://en.wikipedia.org/wiki/Insertion_sort
 * https://algs4.cs.princeton.edu/21elementary/
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static void sort(String[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    swap(data, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(String[] data, int i, int j) {
        final String temp = data[i];
        data[i] = data[j];
        data[j] = temp;
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

            // sort
            sort(strings);

            // output
            for (String sortedString : strings) {
                System.out.println(sortedString);
            }
        }
    }
}
