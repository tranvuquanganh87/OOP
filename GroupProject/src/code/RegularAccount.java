package code;
import java.util.ArrayList;

public class RegularAccount extends Account{

    public RegularAccount(String id, String name, String address, String phoneNumber, ArrayList<Item> rentalList, String username, String password) {
        super(id, name, address, phoneNumber, rentalList, username, password);
    }

    public RegularAccount(String id, String name, String address, String phoneNumber, String username, String password) {
        super(id,name,address,phoneNumber,username,password);
    }

    @Override
    public void display() {
        System.out.println("Regular Account{" +
                "id ='" + super.getId() + '\'' +
                ", name ='" + super.getName() + '\'' +
                ", address ='" + super.getAddress() + '\'' +
                ", phoneNumber ='" + super.getPhoneNumber() + '\'' +
                ", number of rentals =" + super.getRentalList().size() +
                ", username ='" + super.getUsername() + '\'' +
                '}');
    }
}

