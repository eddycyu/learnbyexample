package dev.eddycyu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Longest Common Prefix
 */
public class LongestCommonPrefix {

    private LongestCommonPrefix() {
    }

    /**
     * Given two strings a and b, find the longest substring that appears at the
     * beginning of both strings.
     *
     * @param a first string
     * @param b second string
     * @return longest substring that appears at the beginning of both strings
     */
    public static String lcp(String a, String b) {
        final int N = Math.min(a.length(), b.length());
        for (int i = 0; i < N; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }
        return a.substring(0, N);
    }

    /**
     * Given an array of strings, find the longest substring that appears at the
     * beginning of ALL strings in the array.
     *
     * @param data array of strings
     * @return longest substring that appears at the beginning of ALL strings
     */
    public static String lcp(String[] data) {
        final int N = data.length;
        if (N == 0) {
            return "";
        } else if (N == 1) {
            return data[0];
        } else {
            String prefix = data[0];
            for (String string : data) {
                prefix = lcp(prefix, string);
            }
            return prefix;
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

            // find lcp and output
            System.out.println(lcp(strings));
        }
    }
}
