package by.bsu.mikhed.calc;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Viktoryia_Mikhed on 9/8/2016.
 */
public class Calculator {

    private double firstOperand;
    private double secondOperand;
    private char operation;

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public Calculator() {

    }

    public void readData() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Choose operation: + - * /");
            String o = in.nextLine();
            this.setOperation(o.charAt(0));
            System.out.println("Enter the first operand");
            this.setFirstOperand(in.nextDouble());
            System.out.println("Enter the second operand");
            this.setSecondOperand(in.nextDouble());

        }
        catch(InputMismatchException e) {
            System.out.println("Incorrect input");
        }
    }

    public void calculate() {
        try {
            switch (this.getOperation()) {
                case '+':
                    System.out.println("Result: " + (getFirstOperand() + getSecondOperand()));
                    break;
                case '-':
                    System.out.println("Result: " + (getFirstOperand() - getSecondOperand()));
                    break;
                case '/':
                    System.out.println("Result: " + (getFirstOperand() / getSecondOperand()));
                    break;
                case '*':
                    System.out.println("Result: " + (getFirstOperand() * getSecondOperand()));
                    break;
                default:
                    break;
            }
        }

        catch (ArithmeticException e) {
            System.out.println("Arithmetic exception");
        }


    }
}
