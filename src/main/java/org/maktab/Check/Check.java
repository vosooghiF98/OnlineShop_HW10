package org.maktab.Check;

import org.maktab.Exception.BoundException;
import org.maktab.Exception.InputException;

import java.util.Scanner;

public class Check {
    Scanner input = new Scanner(System.in);
    CheckException checkException = new CheckException();
    public int checkButton(int first, int last) {
        while (true) {
            try {
                return checkException.checkButton(first, last, input);
            }catch (InputException ie){
                System.err.println(ie.getMessage());
                input.next();
            }catch (BoundException be){
                System.err.println(be.getMessage());
            }
        }
    }

    public int checkQuantity() {
        while (true) {
            try {
                return checkException.checkQuantity(input);
            }catch (InputException ie){
                System.err.println(ie.getMessage());
                input.next();
            }catch (BoundException be){
                System.err.println(be.getMessage());
            }
        }
    }

    public String checkNationalCode() {
        while (true) {
            try {
                return checkException.checkNationalCode(input);
            }catch (InputException ie){
                System.err.println(ie.getMessage());
                input.next();
            }catch (BoundException be){
                System.err.println(be.getMessage());
            }
        }
    }

    public String checkName() {
        while (true) {
            try {
                return checkException.checkName(input);
            }catch (InputException ie){
                System.err.println(ie.getMessage());
            }
        }
    }

    public boolean checkYN() {
        while (true) {
            try {
                return checkException.checkYN(input);
            }catch (InputException ie){
                System.err.println(ie.getMessage());
                input.next();
            }
        }
    }

    public int checkPrice() {
        while (true) {
            try {
                return checkException.checkPrice(input);
            } catch (InputException ie) {
                System.err.println(ie.getMessage());
                input.next();
            } catch (BoundException be) {
                System.err.println(be.getMessage());
            }
        }
    }
}
