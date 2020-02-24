package definition;

import adt.LinkedListADTInterface;
import link.Link;

public class LinkedListDefinitionClass implements LinkedListADTInterface {

    private Link first;

    private int size = 0;

    public LinkedListDefinitionClass() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public void add(String fName, String lName, String[] cNumberArray, String eMAddress) {
        sort();
        size++;
        Link newLink = new Link(fName, lName, cNumberArray, eMAddress);
        if (first == null) {
            first = new Link(fName, lName, cNumberArray, eMAddress);
            return;
        }
        newLink.next = null;

        Link last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newLink;
        return;
    }

    @Override
    public void remove() {
        sort();
        System.out.println("Here are all your contacts: ");
        Link current = first;
        traverseIData();
        while (current != null) {
            current.displayLinkDeletion();
            current = current.next;
        }
    }

    public void traverseIData() {
        sort();
        Link temp = first;
        int i = 1;

        while (true) {
            if (temp == null) {
                break;
            }
            temp.iData = i;
            temp = temp.next;
            i++;
        }
    }

    @Override
    public void search(String searchingContact) {
        sort();
        findNode(searchingContact);
    }

    public Link findNode(String searchingContact) {
        Link current = first;
        int contactFound = 0;
        int traversingID = 0;
        if (first == null) {
            return null;
        }

        boolean found = false;
        current = first;
        while (current != null) {
            if (current.fName.compareTo(searchingContact) == 0) {
                found = true;
                contactFound++;
            }
            current = current.next;
        }
        System.out.println(contactFound + " match found!");
        System.out.println("-------- * -------- * -------- * --------");
        Link temp = first;
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.fName.equals(searchingContact)) {
                System.out.println("First Name: " + temp.fName);
                System.out.println("Last Name: " + temp.lName);
                int counterCNumberArray = 0;
                while (temp.cNumberArray[counterCNumberArray] != null) {
                    counterCNumberArray++;
                }
                String[] newCNumberArray = new String[counterCNumberArray];
                for (int i = 0; i < newCNumberArray.length; i++) {
                    newCNumberArray[i] = temp.cNumberArray[i];
                }
                if (counterCNumberArray == 1) {
                    System.out.println("Contact Number: " + newCNumberArray[0]);
                } else {
                    String models = String.join(", ", newCNumberArray);
                    System.out.println("Contact Number(s): " + models);
                }
                if (temp.eMAddress.equals("")) {
                    System.out.println("Email address: Not Entered");
                    System.out.println("-------- * -------- * -------- * --------");
                } else {
                    System.out.println("Email address:" + temp.eMAddress);
                    System.out.println("-------- * -------- * -------- * --------");
                }
            }
            temp = temp.next;
        }

        return current;
    }

    @Override
    public void sort() {
        if (size > 1) {
            boolean nodesChanged;

            do {
                Link current = first;
                Link previous = null;
                Link nextNode = first.next;
                nodesChanged = false;

                while (nextNode != null) {
                    if (current.fName.compareTo(nextNode.fName) > 0) {
                        nodesChanged = true;

                        if (previous != null) {
                            Link temp = nextNode.next;

                            previous.next = nextNode;
                            nextNode.next = current;
                            current.next = temp;
                        } else {
                            Link temp = nextNode.next;

                            first = nextNode;
                            nextNode.next = current;
                            current.next = temp;
                        }

                        previous = nextNode;
                        nextNode = current.next;
                    } else {
                        previous = current;
                        current = nextNode;
                        nextNode = nextNode.next;
                    }
                }
            }
            while (nodesChanged);
        }
    }

    @Override
    public void print() {
        sort();
        System.out.println("---Here are all your contacts---");
        System.out.println("-------- * -------- * -------- * --------");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
            System.out.println("-------- * -------- * -------- * --------");
            System.out.println("-------- * -------- * -------- * --------");
        }
    }
}
