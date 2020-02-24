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
    }

}
