package Homework2.Task8;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }

    public Fraction substract(Fraction other) {
        int numerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;

        return new Fraction(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

}
