package by.bsu.mikhed.main;

import by.bsu.mikhed.calc.Calculator;

/**
 * Created by Viktoryia_Mikhed on 9/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        while (true) {
            calc.readData();
            calc.calculate();
        }
    }
}
