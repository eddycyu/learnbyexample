package dev.eddycyu.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge sort.
 * <p>
 * Given an unsorted array of strings, sort the strings in ascending order.
 * <p>
 * https://en.wikipedia.org/wiki/Merge_sort
 * https://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 * <p>
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class MergeSort {

    private MergeSort() {
    }

    public static void sort(String[] data) {
        final String[] aux = new String[data.length];
        sort(data, aux, 0, data.length);
    }

    private static void sort(String[] data, String[] aux, int lo, int hi) {
        final int N = hi - lo;
        if (N <= 1) {
            return;
        }
        final int mid = lo + N / 2;
        sort(data, aux, lo, mid);
        sort(data, aux, mid, hi);
        merge(data, aux, lo, mid, hi);
    }

    private static void merge(String[] data, String[] aux, int lo, int mid, int hi) {
        // merge data[lo,mid) with data[mid,hi) into aux[0, hi-lo)
        int i = lo;
        int j = mid;
        final int N = hi - lo;
        for (int k = 0; k < N; k++) {
            if (i == mid) {
                aux[k] = data[j++];
            } else if (j == hi) {
                aux[k] = data[i++];
            } else if (data[j].compareTo(data[i]) < 0) {
                aux[k] = data[j++];
            } else {
                aux[k] = data[i++];
            }
        }
        // copy from aux back to data
        if (N >= 0) {
            System.arraycopy(aux, 0, data, lo, N);
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

            // sort
            sort(strings);

            // output
            for (String sortedString : strings) {
                System.out.println(sortedString);
            }
        }
    }
}
