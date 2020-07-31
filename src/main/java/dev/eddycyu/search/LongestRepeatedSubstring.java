package dev.eddycyu.search;

import dev.eddycyu.sort.MergeSort;

/**
 * Longest Repeated Substring
 * <p>
 * Given an input string, find the longest substring in the string that occurs at least twice.
 * <p>
 * This solution use a suffix array to solve the problem.
 * <p>
 * https://en.wikipedia.org/wiki/Longest_repeated_substring_problem
 * https://en.wikipedia.org/wiki/Suffix_array
 * <p>
 * Time Complexity: O(n log n)
 */
public class LongestRepeatedSubstring {

    private LongestRepeatedSubstring() {
    }

    public static String lrs(String input) {
        // form suffix array
        final int N = input.length();
        final String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = input.substring(i, N);
        }

        // sort the suffix array in ascending order
        MergeSort.sort(suffixes);

        // find LCP (longest common prefix) among adjacent entries
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            final String lcp = LongestCommonPrefix.lcp(suffixes[i], suffixes[i + 1]);
            if (lcp.length() > lrs.length()) {
                lrs = lcp;
            }
        }
        return lrs;
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(lrs(input));
    }
}
