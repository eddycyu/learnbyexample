package dev.eddycyu.permutation;

import java.util.Arrays;

/**
 * Given a sequence of integers, generate all possible permutations using
 * Heap's algorithm.
 * <p>
 * This solution is implemented using iteration.
 * <p>
 * https://en.wikipedia.org/wiki/Permutation
 *
 * @see dev.eddycyu.permutation.HeapsRecursion
 */
public class HeapsIteration {

    /**
     * Generate permutations using Heap's algorithm.
     * <p>
     * https://en.wikipedia.org/wiki/Heap%27s_algorithm
     */
    private static void permute(int[] sequence, int n) {

        // c is an encoding of the stack state; c[k] encodes the for-loop
        // counter for when permute(sequence, k+1) is called
        int[] c = new int[n];

        // output permutation
        System.out.println(Arrays.toString(sequence));

        int k = 0;
        while (k < n) {
            if (c[k] < k) {
                int temp;
                if (k % 2 == 0) {
                    // if even, the swap the first and kth element
                    temp = sequence[0];
                    sequence[0] = sequence[k];
                } else {
                    temp = sequence[c[k]];
                    sequence[c[k]] = sequence[k];
                }
                sequence[k] = temp;

                // output permutation
                System.out.println(Arrays.toString(sequence));

                // swap has occurred ending the for-loop; simulate the increment
                // of the for-loop counter
                c[k] += 1;

                // simulate recursive call reaching the base case by bringing
                // the pointer to the base case analogy in the array
                k = 0;
            } else {
                // calling permute(sequence, k+1) has ended as the for-loop
                // terminated; reset the state and simulate popping the stack
                // by incrementing the pointer
                c[k] = 0;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        final int[] sequence = {1, 2, 3};

        // number of element in the sequence
        final int n = sequence.length;

        // generate permutations
        permute(sequence, n);
    }
}
