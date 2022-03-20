package ru.gb.lessons.lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Locale;

@Data
@AllArgsConstructor
public class Triangle {

    private int a;
    private int b;
    private int c;

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    private Color colour;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.colour = Color.WHITE;
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
    }

    private void checkOneSideIsSmallerThanSumOfOthers() {
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalArgumentException("One side can't be greater than sum of others");
        }
    }

    public int countPerimeter() {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        return a + b + c;
    }

    public void paint(Color colour) {
        if (this.colour == colour) {
            throw new IllegalArgumentException("New colour must not be equal to old colour");
        }
        this.colour = colour;
    }

    public void paint(String colour) {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        paint(Color.valueOf(colour));
    }


    public double countArea() {
        // TODO: 01.03.2022 realize https://shkolkovo.net/theory/128
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        double p = countPerimeter() / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return Double.valueOf(String.format(Locale.US, "%.2f", s));
    }



    public Triangle createSimilarTriangle(int coef) {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        // TODO: 01.03.2022 добавить проверку коэффициента
        if (coef <= 0) {
            throw new IllegalArgumentException("The coef must be positive number");
        }
        return new Triangle(a * coef, b * coef, c * coef);
    }
}
