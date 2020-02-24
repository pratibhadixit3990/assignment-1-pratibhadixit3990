package link;

public class Link {

    public int iData = 1;

    public String fName, lName;

    public String[] cNumberArray = new String[100];

    public String eMAddress;

    public Link next;

    public Link(String fName, String lName, String[] cNumberArray, String eMAddress) {
        this.fName = fName;
        this.lName = lName;
        this.cNumberArray = cNumberArray;
        this.eMAddress = eMAddress;
    }

    public void displayLink() {
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        int counterCNumberArray = 0;
        while (cNumberArray[counterCNumberArray] != null) {
            counterCNumberArray++;
        }
        String[] newCNumberArray = new String[counterCNumberArray];
        for (int i = 0; i < newCNumberArray.length; i++) {
            newCNumberArray[i] = cNumberArray[i];
        }
        if (counterCNumberArray == 1) {
            System.out.println("Contact Number: " + newCNumberArray[0]);
        } else {
            String models = String.join(", ", newCNumberArray);
            System.out.println("Contact Number(s): " + models);
        }
        if (eMAddress.equals("")) {
            System.out.println("Email address: Not Entered");
        } else {
            System.out.println("Email address:" + eMAddress);
        }
    }

    public void displayLinkDeletion() {
        System.out.println(iData + ". " + fName + " " + lName);
    }
}
