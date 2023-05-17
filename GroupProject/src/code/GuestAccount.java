package code;
import utilities.ErrorHandle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GuestAccount extends Account{
    public GuestAccount(String id, String name, String address, String phoneNumber, ArrayList<Item> rentalList, String username, String password) {
        super(id, name, address, phoneNumber, rentalList, username, password);
    }

    public GuestAccount(String id, String name, String address, String phoneNumber, String username, String password) {
        super(id, name, address, phoneNumber, username, password);
    }

    @Override
    public void display() {
        System.out.println("Guest Account{" +
                "id ='" + super.getId() + '\'' +
                ", name ='" + super.getName() + '\'' +
                ", address ='" + super.getAddress() + '\'' +
                ", phoneNumber ='" + super.getPhoneNumber() + '\'' +
                ", number of rentals =" + super.getRentalList().size() +
                ", username ='" + super.getUsername() + '\'' +
                '}');
    }

    public void rentItem (String itemId, String amount) {
        // If the current user want to borrow the third item.
        if (this.getRentalList().size() > 2) {
            System.out.println("Guest Account can only rent 2 items at a time!");
            return;
        }

        Item item = VideoStore.findItem(itemId);
        if (item == null) {
            return;
        }
        // Guest account can only rent 1-week loan item
        if (Objects.equals(item.getLoanType().toLowerCase(), "2-day loan".toLowerCase())) {
            System.out.println("Guest cannot borrow a 2-day loan item!");
            return;
        }
        super.rentItem(itemId, amount);
    }
}
