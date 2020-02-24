package person;

import definition.LinkedListDefinitionClass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    final static Scanner scanner = new Scanner(System.in);

    LinkedListDefinitionClass list = new LinkedListDefinitionClass();

    String fName, lName;

    String[] cNumberArray = new String[100];

    String eMAddress = "";

    private void enteringContactListApp() {
        try {
            Person call = new Person();
            System.out.println();
            System.out.println("Welcome to Contact List App");
            System.out.println("Press 1 to add a new contact");
            System.out.println("Press 2 to view all contacts");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 5 to exit program");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println();
                    System.out.println("Add a contact");
                    contactAddition();
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("View all contacts");
                    contactView();
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("Search for a contact");
                    contactSearching();
                    break;
                }
                case 4: {
                    System.out.println();
                    System.out.println("Delete from contact");
                    contactDeletion();
                    break;
                }
                case 5: {
                    System.out.println();
                    System.out.println("Thanks for using the Contact List App. ");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println();
                    System.out.println("You have entered the unexpected value.");
                    System.out.println("Do you again want to enter the Contact List App");
                    System.out.println("If yes press 1 otherwise press any other digit and you will get exit from this app");
                    int choiceAgain = scanner.nextInt();
                    if (choiceAgain == 1) {
                        call.enteringContactListApp();
                    } else {
                        System.out.println();
                        System.out.println("Thanks for using the Contact List App. Visit again!!");
                        System.exit(0);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception has occurred");
            System.out.println("The Contact List App has encounterd a problem");
            System.out.println("We are sorry for the interrupt");
            System.out.println("Please, wait while the App is being closed!!!");
            System.out.println();
            System.out.println("Thanks for using the Contact List App");
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch Exception has occurred");
            System.out.println("The Contact List App has encounterd a problem");
            System.out.println("We are sorry for the interrupt");
            System.out.println("Please, wait while the App is being closed!!!");
            System.out.println();
            System.out.println("Thanks for using the Contact List App");
        } catch (Exception e) {
            System.out.println("Exception has occurred");
            System.out.println("The Contact List App has encounterd a problem");
            System.out.println("We are sorry for the interrupt");
            System.out.println("Please, wait while the App is being closed!!!");
            System.out.println();
            System.out.println("Thanks for using the Contact List App");
        }

    }

    private void contactDeletion() {
    }

    private void contactSearching() {
    }

    private void contactView() {
    }

    private void contactAddition() {

    }

    private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;
    }

    private static boolean isStringOnlyAlphabet(String str) {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    private static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}
