package com.cdac.acts.day9.Tester;

import com.cdac.acts.day9.calc.Calculator;
import com.cdac.acts.day9.calc.IntegerCalculator;

import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Calculator calculator = new IntegerCalculator();

        System.out.print("Enter first number: ");
        Number num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        Number num2 = scanner.nextInt();

        Integer result = (Integer) calculator.add(num1, num2);
        System.out.println("Integer Result: " + result);

        Number result1 = calculator.add(num1, num2);
        System.out.println("Number Result: " + result1);
    }
}
