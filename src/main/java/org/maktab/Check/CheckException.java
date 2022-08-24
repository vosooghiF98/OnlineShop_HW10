package org.maktab.Check;

import org.maktab.Exception.BoundException;
import org.maktab.Exception.InputException;

import java.util.Scanner;

public class CheckException {
    public int checkButton(int first, int last, Scanner input) {
        System.out.print("Enter Your Function : ");
        int button;
        if (input.hasNextInt()) {
            int temp = input.nextInt();
            if (temp >= first && temp <= last) {
                button = temp;
                return button;
            } else {
                throw new BoundException("Enter Number Between " + first + " and " + last);
            }
        } else {
            throw new InputException("Enter Number!");
        }
    }

    public int checkQuantity(Scanner input) {
        int quantity;
        if (input.hasNextInt()) {
            int temp = input.nextInt();
            if (temp > 0) {
                quantity = temp;
                return quantity;
            } else {
                throw new BoundException("Enter Quantity Greater than 0! : ");
            }
        } else {
            throw new InputException("Enter Number! : ");
        }
    }

    public String checkNationalCode(Scanner input) {
        System.out.print("Enter national code : ");
        String nationalCode;
        if (input.hasNextInt()) {
            String temp = input.next();
            if (temp.length() == 10) {
                nationalCode = temp;
                return nationalCode;
            } else {
                throw new BoundException("Enter 10 Number! : ");
            }
        } else {
            throw new InputException("Enter Number! : ");
        }
    }

    public String checkName(Scanner input) {
        String name;
        name = input.next();
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                throw new InputException("Enter Character! : ");
            }
        }
        return name;
    }


    public boolean checkYN(Scanner input) {
        String yn = input.next();
        if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")) {
            return yn.equalsIgnoreCase("y");
        } else {
            throw new InputException("Please Enter Y or N!");
        }
    }

    public int checkPrice(Scanner input) {
        int price;
        if (input.hasNextLong()) {
            int temp = input.nextInt();
            if (temp > 0) {
                price = temp;
                return price;
            } else {
                throw new BoundException("Enter Price Greater than 0! : ");
            }
        } else {
            throw new InputException("Enter Number! : ");
        }
    }
}
