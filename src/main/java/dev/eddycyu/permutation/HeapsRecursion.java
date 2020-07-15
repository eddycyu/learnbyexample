package dev.eddycyu.permutation;

import java.util.Arrays;

/**
 * Given a sequence of integers, generate all possible permutations using
 * Heap's algorithm.
 * <p>
 * This solution is implemented using recursion.
 * <p>
 * https://en.wikipedia.org/wiki/Permutation
 *
 * @see dev.eddycyu.permutation.HeapsIteration
 */
public class HeapsRecursion {

    /**
     * Generate permutations using Heap's algorithm.
     * <p>
     * https://en.wikipedia.org/wiki/Heap%27s_algorithm
     */
    private static void permute(int[] sequence, int k) {
        if (k == 1) {
            // output permutation
            System.out.println(Arrays.toString(sequence));
        } else {
            // generate permutations with kth unaltered;
            // initially k == sequence.length
            permute(sequence, k - 1);

            // generate permutation for kth swapped with each k-1 initial
            for (int i = 0; i < k - 1; i++) {
                int temp;
                if (k % 2 == 0) {
                    // if even, the swap the ith and last (k-1) element
                    temp = sequence[i];
                    sequence[i] = sequence[k - 1];
                } else {
                    // else swap the first and last (k-1) element
                    temp = sequence[0];
                    sequence[0] = sequence[k - 1];
                }
                sequence[k - 1] = temp;
                permute(sequence, k - 1);
            }
        }
    }

    public static void main(String[] args) {
        final int[] sequence = {1, 2, 3};

        // kth element in the sequence; initially k == sequence.length
        final int k = sequence.length;

        // generate permutations
        permute(sequence, k);
    }
}
