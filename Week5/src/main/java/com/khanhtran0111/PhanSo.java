package com.khanhtran0111;


// Import your library
// Do not change the name of the Solution class
public class PhanSo {
    // Type your main code here
    /**
     * An especially short bit of Javadoc.
     */
    private int numerator;
    private int denominator = 1;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public int getDenominator() {
        if (denominator != 0) {
            return denominator;
        }
        return this.denominator;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * An especially short bit of Javadoc.
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Solution reduce() {
        int chung = gcd(denominator, numerator);
        denominator /= chung;
        numerator /= chung;
        return this;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Solution add(Solution other) {
        numerator = numerator * other.denominator + other.numerator * denominator;
        denominator = other.denominator * denominator;
        return this;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Solution subtract(Solution other) {
        numerator = numerator * other.denominator - other.numerator * denominator;
        denominator = other.denominator * denominator;
        return this;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Solution multiply(Solution other) {
        numerator = numerator * other.numerator;
        denominator = other.denominator * denominator;
        return this;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Solution divide(Solution other) {
        if (other.denominator != 0) {
            numerator = numerator * other.denominator;
            denominator = denominator * other.numerator;
            return this;
        }
        return this;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {

            Solution other = (Solution) obj;
            // compare this vs other here
            other = other.reduce();
            Solution present = this.reduce();
            return (present.numerator == other.numerator
                    && present.denominator == other.denominator);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}


