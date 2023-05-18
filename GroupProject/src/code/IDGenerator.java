package code;

public class IDGenerator {
    private static int customerID = 0;
    private static int itemID = 0;

    public IDGenerator(){

    }

    public static String getCustomerID() {

        customerID++;
        if (customerID > 999)
            return null;
        return String.format("C%03d", customerID);
    }
    public static String getItemID() {
        itemID++;
        if (itemID > 999)
            return null;
        return String.format("I%03d", customerID);
    }

}
