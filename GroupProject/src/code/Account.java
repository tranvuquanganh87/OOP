package code;
import utilities.ErrorHandle;

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

    public void rentItem(String itemId, String amount) {
        Item item = ErrorHandle.itemValidate(itemId);

        // No item found
        if (item == null) {
            return;
        }
        // Validate the number of copies
        if (!ErrorHandle.rentAmountValidate(item, amount)) {
            return;
        }

        // update
        item.setNumberOfCopies(item.getNumberOfCopies() - Integer.parseInt(amount));

        // Add the current rental with its number of copies
        for (int i = 0; i < Integer.parseInt(amount); i++) {
            this.getRentalList().add(item);
        }

        System.out.println("Order successfully!");
    }
}
