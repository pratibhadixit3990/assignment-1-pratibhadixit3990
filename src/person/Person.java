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

    private void exitingContactListApp() {
        System.out.println();
        System.out.println("Thanks for using the Contact List App. Visit Again!!");
        System.exit(0);
    }

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
        list.remove();
        System.out.print("Press the number against the contact to delete it: ");
        int contactIndexForDeletion = scanner.nextInt();
        list.delete(contactIndexForDeletion);
        enteringContactListApp();
    }

    private void contactSearching() {
        System.out.println("You could search for a contact fron their first names: ");
        String searchingContact = scanner.next();
        list.search(searchingContact);
        enteringContactListApp();
    }

    private void contactView() {
        list.print();
        enteringContactListApp();
    }

    private void contactAddition() {
        String cNumber;
        char choiceCNumber = 'y', choiceFName, choiceLName, choiceEMAdddress;
        int i = 0;
        System.out.println("You have chosen to add a new contact: ");
        System.out.println("Please enter the name of the Person");


        System.out.print("First Name: ");
        fName = scanner.next();
        if (isStringOnlyAlphabet(fName)) {
        } else {
            System.out.println("Sorry, but your first name should contain alphabets only");
            System.out.println("Do you again want to enter the first name?");
            System.out.print("If yes than press 'y' otherwise press any other key on keyboard to exit Add module: ");
            choiceFName = scanner.next().charAt(0);
            if (choiceFName == 'y') {
                System.out.print("First Name: ");
                fName = scanner.next();
            } else {
                System.exit(0);
            }

        }

        System.out.print("Last Name: ");
        lName = scanner.next();
        if (isStringOnlyAlphabet(lName)) {
        } else {
            System.out.println("Sorry, but your last name should contain alphabets only");
            System.out.println("Do you again want to enter the last name?");
            System.out.print("If yes than press 'y' otherwise press any other key on keyboard to exit Add module: ");
            choiceLName = scanner.next().charAt(0);
            if (choiceLName == 'y') {
                System.out.print("Last Name: ");
                lName = scanner.next();
            } else {
                System.exit(0);
            }

        }

        System.out.print("Contact Number: ");
        cNumber = scanner.next();
        if (validatePhoneNumber(cNumber)) {
            int sameContactNumber = 0;
            for (int k = 0; k <= i; k++) {
                if (cNumber.equals(cNumberArray[k])) {
                    sameContactNumber++;
                }
            }
            if (sameContactNumber == 0) {
                cNumberArray[i] = cNumber;
                i++;
                System.out.println("Contact Number Added");
            } else {
                System.out.println("You have inputted same contact number.");
                System.out.println("Please enter a different contact number");
            }
        } else {
            System.out.println("You have inputted invalid phone number");
        }
        while (choiceCNumber == 'y') {
            System.out.print("Would you like to add another contact number? (y/n): ");
            choiceCNumber = scanner.next().charAt(0);
            if (choiceCNumber == 'y') {
                System.out.print("Contact Number: ");
                cNumber = scanner.next();
                if (validatePhoneNumber(cNumber)) {
                    int sameContactNumber = 0;
                    for (int k = 0; k <= i; k++) {
                        if (cNumber.equals(cNumberArray[k])) {
                            sameContactNumber++;
                        }
                    }
                    if (sameContactNumber == 0) {
                        cNumberArray[i] = cNumber;
                        i++;
                        System.out.println("Contact Number Added");
                    } else {
                        System.out.println("You have inputted same contact number.");
                        System.out.println("Please enter a different contact number");
                    }
                } else {
                    System.out.println("You have inputted invalid phone number");
                }
            } else if (choiceCNumber == 'n') {
                break;
            }
        }

        System.out.print("Would you like to add email address? (y/n): ");
        choiceEMAdddress = scanner.next().charAt(0);
        if (choiceEMAdddress == 'y') {
            System.out.print("Email Address: ");
            eMAddress = scanner.next();
            if (isValid(eMAddress)) {
            } else {
                while (choiceEMAdddress == 'y') {
                    System.out.println("You have inputted an invalid Email Address");
                    System.out.print("Do you again want to enter the email address? (y/n): ");
                    choiceEMAdddress = scanner.next().charAt(0);
                    if (choiceEMAdddress == 'y') {
                        System.out.print("Email Address: ");
                        eMAddress = scanner.next();
                        if (isValid(eMAddress)) {
                            break;
                        }
                    }
                }
            }
        }


        list.add(fName, lName, cNumberArray, eMAddress);
        System.out.println("A new Contact Added");
        enteringContactListApp();
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
