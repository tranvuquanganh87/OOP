package code;

import utilities.Database;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    private final String username;
    private final String password;
    private static ArrayList<Item> itemList = Database.loadItemData();
    private static ArrayList<Account> accountList = Database.loadAccountData();
    private static Database database;
    private VideoStore videoStore = new VideoStore(itemList, accountList, database);

    public Admin() {
        this.username = " ";
        this.password = " ";
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addStock() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the id: ");
        String id = scan.next();
        System.out.println("Enter the type of item: ");
        String type = scan.nextLine();
        System.out.println("Enter the quantity: ");
        int quantity = scan.nextInt();

        // add Stock
        for (int i = 0; i < videoStore.getItemList().size();i++){
            if (Objects.equals(videoStore.getItemList().get(i).getId(), id)) {
                videoStore.getItemList().get(i).setNumberOfCopies(quantity);
                videoStore.getItemList().get(i).setRentalStatus(true);
                break;
            }
        }
    }
}
