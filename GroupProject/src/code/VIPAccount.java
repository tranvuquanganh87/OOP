package code;
import java.util.ArrayList;

public class VIPAccount extends Account{
    private double vipPoint;

    public VIPAccount(String id, String name, String address, String phoneNumber, ArrayList<Item> rentalList, String username, String password) {
        super(id, name, address, phoneNumber, rentalList, username, password);
//        this.vipPoint = vipPoint;
    }

    public VIPAccount() {
        super();
        this.vipPoint = 0;
    }

    public VIPAccount(String id ,String name, String address, String phoneNumber, String username, String password) {
        super(id, name, address, phoneNumber, username, password);
        this.vipPoint = vipPoint;
    }

    public void display() {
        System.out.println("VIP Account{" +
                "id= '" + super.getId() + '\'' +
                ", name ='" + super.getName() + '\'' +
                ", address ='" + super.getAddress() + '\'' +
                ", phoneNumber ='" + super.getPhoneNumber() + '\'' +
                ", number of rentals = " + super.getRentalList().size() +
                ", username ='" + super.getUsername() + '\'' +
                '}');
    }

    public void rentItem(String itemId, String amount) {
        super.rentItem(itemId, amount);
    }
}
