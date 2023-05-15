package code;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Item> rentalList;
    private String username;
    private String password;

    public Account(String id, String name, String address, String phoneNumber, ArrayList<Item> rentalList, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rentalList = rentalList;
        this.username = username;
        this.password = password;
    }

    public Account() {
        this.id = "";
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.rentalList = new ArrayList<Item>();
        this.username = "";
        this.password = "";
    }

    public Account(String id, String name, String address, String phoneNumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.rentalList = new ArrayList<Item>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Item> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<Item> rentalList) {
        this.rentalList = rentalList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void display();
    public static Item validateOrder () {

        // Only show items that is available for rent
        for (Item i : VideoStore.getItemList()) {
            if (i.isRentalStatus()) {
                i.display();
            }
        }
        System.out.print("Enter id: ");
        Scanner input = new Scanner(System.in);
        String rentItemId = input.nextLine();
        Item tmp = VideoStore.findItem(rentItemId);

        // Check if the item is in the list
        if (tmp == null) {
            System.out.println("The item you entered is not available!");
            return null;
        }
        return tmp;
    }
    public void rentItem(Item item) {
        Scanner input = new Scanner(System.in);
        // Validate the number of copies taken from the customer
        String rentNumber;
        while (true) {
            System.out.print("Enter number of copies: ");
            rentNumber = input.nextLine();
            // Try catch for parseInt (if the input contains alphabetical letter)
            try {
                int num = Integer.parseInt(rentNumber);
                if (num < 0 || num > item.getNumberOfCopies()) {
                    System.out.println("Number of copies entered is invalid!");
                } else {
                    break;
                }
            }catch (NumberFormatException e) {
                System.out.println("Please enter a numeric value!");
            }
        }
        item.setNumberOfCopies(item.getNumberOfCopies() - Integer.parseInt(rentNumber));
        // Add the current rental with its number of copies
        for (int i = 0; i < Integer.parseInt(rentNumber); i++) {
            this.getRentalList().add(item);
        }

        System.out.println("Order successfully!");
    }
}
