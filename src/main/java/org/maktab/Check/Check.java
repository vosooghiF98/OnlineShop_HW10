package org.maktab.Check;

import org.maktab.Exception.BoundException;
import org.maktab.Exception.InputException;

import java.util.Scanner;

public class Check {
    public int checkButton(int first, int last, Scanner input) {
        while (true) {
            try {
                return CheckException.checkButton(first, last, input);
            }catch (InputException ie){
                System.out.println(ie.getMessage());
                input.next();
            }catch (BoundException be){
                System.out.println(be.getMessage());
            }
        }
    }

    public int checkQuantity(Scanner input) {
        while (true) {
            try {
                return CheckException.checkQuantity(input);
            }catch (InputException ie){
                System.out.println(ie.getMessage());
                input.next();
            }catch (BoundException be){
                System.out.println(be.getMessage());
            }
        }
    }

    public String checkNationalCode(Scanner input) {
        while (true) {
            try {
                return CheckException.checkNationalCode(input);
            }catch (InputException ie){
                System.out.println(ie.getMessage());
                input.next();
            }catch (BoundException be){
                System.out.println(be.getMessage());
            }
        }
    }

    public String checkName(Scanner input) {
        while (true) {
            try {
                return CheckException.checkName(input);
            }catch (InputException ie){
                System.out.println(ie.getMessage());
            }
        }
    }

    public boolean checkYN(Scanner input) {
        while (true) {
            try {
                return CheckException.checkYN(input);
            }catch (InputException ie){
                System.out.println(ie.getMessage());
                input.next();
            }
        }
    }

    public int checkPrice(Scanner input) {
        while (true) {
            try {
                return CheckException.checkPrice(input);
            } catch (InputException ie) {
                System.out.println(ie.getMessage());
                input.next();
            } catch (BoundException be) {
                System.out.println(be.getMessage());
            }
        }
    }
}
