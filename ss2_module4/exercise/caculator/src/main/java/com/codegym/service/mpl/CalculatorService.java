package com.codegym.service.mpl;

import com.codegym.service.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculator {

    @Override
    public String result(double number1, double number2, String str) {
        String result = "";
        switch (str) {
            case "+":
                result = String.valueOf(number1 + number2);
                break;
            case "-":
                result = String.valueOf(number1 - number2);
                break;
            case "*":
                result = String.valueOf(number1 * number2);
                break;
            case "/":
                if (number2 == 0) {
                    result = "cannot be divided by 0";
                }
                if (number2 != 0) {
                    result = String.valueOf(number1 / number2);
                }
                break;
        }
        return result;
    }
}
