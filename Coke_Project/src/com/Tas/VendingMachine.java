package com.Tas;
import java.util.Scanner;

/**
 * Created by TasdiqueC on 6/12/17.
 */
public class VendingMachine {
    /****** private variables *******/
    private static int lastInputGiven;
    private static int currentUserTotal;
    private static int necessaryTotal;

    /****** constructor *******/

    public VendingMachine () {
        setValuesToZero();
    }


    /****** public methods ******/

    public static void setValuesToZero () {
        currentUserTotal = 0;
        necessaryTotal = 0;
    }

    public static void incrementNecessaryTotal() {
        necessaryTotal += 100;
    }

    public static void updateUserTotal(){currentUserTotal += lastInputGiven;}

    // Take an input and update the private variable
    public static void takeInput() {
        Scanner input = new Scanner(System.in);
        lastInputGiven = input.nextInt();
    }


    // Checks to see if the drink is valid
    public static boolean checkDrinks (int drinkNumber) {
        if (drinkNumber == 1 || drinkNumber == 2 || drinkNumber == 3) return true;
        else return false;
    }

    // Check to see if the value given is a nickel, dime, or quarter.
    public static boolean checkCoinValue (int coin) {
        if (coin == 25 || coin == 10 || coin == 5) return true;
        else return false;
    }

    public static void doesUserMatchTotal () {
        if (currentUserTotal >= necessaryTotal) {
            menu(6);
        }
    }

    public static void drinksAndMenu () {
        takeInput();
        if (checkDrinks(lastInputGiven)) {
            incrementNecessaryTotal();
            menu(2);
        }
        else menu(3);
    }

    public static void coinsAndMenu() {
        takeInput();
        if (checkCoinValue(lastInputGiven)) {
            updateUserTotal();
            doesUserMatchTotal();
            menu(4);
        }
        else menu (5);
    }

    public static void addDrinksConfirmation () {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();

        if (x == 10) {
            System.out.println("Please input your drink number: ");
            drinksAndMenu();
            menu(2);
        }
        else if (x == 11) {
            menu(4);
        }
        else {
            System.out.println("Please type in a proper confirmation number: ");
            addDrinksConfirmation();
        }
    }

    // The menu for the user
    // Occurrence handled by the programmer
    public static void menu(int occurrence) {
        if (occurrence == 1) { // welcome message
            System.out.println("Hello! Welcome to Tasdique's Vending Machine 1.0. We have three options for you:" +
                    "Coke [1], Coke Zero [2], and Caffeine Free Diet Coke [3]. Each costs $1." +
                    "This machine only accepts nickels, dimes, and quarters. " +
                    "Of course, your change will be reimbursed. Please input the number of the drink " +
                    "you want to continue: ");
            drinksAndMenu();
        }
        else if (occurrence == 2) { // valid drink input
            System.out.println("Thank you for inputting in a proper drink number. " +
                    "Your total has been updated to: " + necessaryTotal + ". Would you like to buy another drink? " +
                    "If yes, type '10', if no type '11': ");
            addDrinksConfirmation();
        }
        else if (occurrence == 3) { // invalid drink input
            System.out.println("Please try inputting your value again: ");
            drinksAndMenu();
        }
        else if (occurrence == 4) { // valid coin input
            System.out.println("Your current total is: " + currentUserTotal + ". Please only input nickels, dimes, or quarters: ");
            coinsAndMenu();
        }
        else if (occurrence == 5) { // invalid coin input
            System.out.println("The value you have inputted is invalid. Please try again, with only nickels, dimes, or quarters: ");
            coinsAndMenu();
        }
        else if (occurrence == 6) {
            System.out.println("Your payment is done.");
            if (currentUserTotal > necessaryTotal) {
                int difference = currentUserTotal - necessaryTotal;
                if (difference == 15) {System.out.println("Your change is: " + difference + ". Returning a dime and a nickel...");}
                else if (difference == 10) {System.out.println("Your change is: " + difference + ". Returning a dime...");}
                else if (difference == 5) {System.out.println("Your change is: " + difference + ". Returning a nickel...");}
                else if (difference == 20) {System.out.println("Your change is: " + difference + ". Returning two dimes...");}
                System.out.println("Exiting application...");
                System.exit(0);
            }
            System.out.println("No receipt.");
            System.exit(0);
        }
    }
}
