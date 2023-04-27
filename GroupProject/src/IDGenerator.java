public class IDGenerator {
    private static int customerID = 0;
    private static int itemID = 0;

    public IDGenerator(int customerID, int itemID) {
        this.customerID = customerID;
        this.itemID = itemID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
}
