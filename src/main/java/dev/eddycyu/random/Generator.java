package dev.eddycyu.random;

public class Generator {

    /**
     * Generate a random string of specified length and composed of elements
     * from a specified character set.
     *
     * @param length length of random string
     * @param chars  character set for composing string
     * @return random string of specified length
     * from specified data set
     */
    public static String randomString(int length, String chars) {
        final char[] buffer = new char[length];
        for (int i = 0; i < buffer.length; i++) {
            int j = (int) (Math.random() * chars.length());
            buffer[i] = chars.charAt(j);
        }
        return new String(buffer);
    }

    /**
     * Generate random strings of specified length and composed of elements
     * from a specified character set.
     *
     * @param count  number of strings to generate
     * @param length length of each random string
     * @param chars  character set for composing strings
     * @return array of random strings of specified length
     */
    public static String[] randomStrings(int count, int length, String chars) {
        final String[] strings = new String[count];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = randomString(length, chars);
        }
        return strings;
    }

    /**
     * Generate N random strings of length L composed of elements from a
     * specified character set.
     *
     * @param args [0] generate N random strings
     *             [1] each string is of length L
     *             [2] character set for composing strings
     */
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final int L = Integer.parseInt(args[1]);
        final String chars = args[2];
        final String[] randomStrings = randomStrings(N, L, chars);
        for (String randomString : randomStrings) {
            System.out.println(randomString);
        }
    }
}
