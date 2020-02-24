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

    }

    @Override
    public void search(String searchingContact) {

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

    }
}
