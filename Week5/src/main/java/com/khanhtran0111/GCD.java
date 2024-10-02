package com.khanhtran0111;

public class GCD {
    // Type your main code here
    /**
     * An especially short bit of Javadoc.
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Math.abs(gcd(b, a % b));
    }
}

