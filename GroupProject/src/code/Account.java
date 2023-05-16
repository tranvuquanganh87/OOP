package code;

import utilities.Database;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class Account {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Item> rentalList;
    private String username;
    private String password;
    private static ArrayList<Item> itemList = Database.loadItemData();
    private static ArrayList<Account> accountList = Database.loadAccountData();
    private static Database database;
    private VideoStore videoStore = new VideoStore(itemList, accountList, database);

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

    public void rentItem() {
        // enter the info rental item
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the item's id: ");
        String id = scan.next();


        // rent item func
        for (int i = 0; i < videoStore.getItemList().size(); i++) {
            int quantity = videoStore.getItemList().get(i).getNumberOfCopies() - 1;
            if (Objects.equals(videoStore.getItemList().get(i).getId(), id)) {
                rentalList.add(videoStore.getItemList().get(i));
                videoStore.getItemList().get(i).setNumberOfCopies(quantity);
                if (videoStore.getItemList().get(i).getNumberOfCopies() == 0) videoStore.getItemList().get(i).setRentalStatus(false);
                break;
            }
        }
    }

//    public void returnItem(){
//
//    }
}
