package code;

import utilities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VideoStore {
    private static ArrayList<Item> itemList = Database.loadItemData();
    private static ArrayList<Account> accountList = Database.loadAccountData();
    private static Database database;

    public VideoStore(ArrayList<Item> itemList, ArrayList<Account> accountList, Database database) {
        this.itemList = itemList;
        this.accountList = accountList;
        this.database = database;
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public static ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public static boolean addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO GENIE'S VIDEO STORE!!!");

        // Register phase: Name
        System.out.print("PLEASE ENTER YOUR NAME: ");
        String name = scanner.nextLine();
        if (!ErrorHandle.customerNameValidate(name)) {
            System.out.println("Error 1");
            return false;
        }

        // Register phase: Address
        System.out.print("PLEASE ENTER YOUR ADDRESS: ");
        String address = scanner.nextLine();
        if (!ErrorHandle.customerAddressValidate(address)) {
            System.out.println("Error 2");
            return false;
        }

        // Register phase: Phone Number
        System.out.print("PLEASE ENTER YOUR PHONE NUMBER: ");
        String phoneNum = scanner.nextLine();
        if (!ErrorHandle.customerPhoneNumberValidate(phoneNum)) {
            System.out.println("Error 3");
            return false;
        }

        // Register phase: Username
        System.out.print("PLEASE ENTER YOUR USERNAME: ");
        String username = scanner.nextLine();
        if (!ErrorHandle.customerUsernameValidate(username)) {
            System.out.println("Error 4");
            return false;
        }


        // Register phase: Password
        System.out.print("PLEASE ENTER YOUR PASSWORD: ");
        String password = scanner.nextLine();
        if (!ErrorHandle.customerPasswordValidate(password)) {
            System.out.println("Error 5");
            return false;
        }

        Account newAcc = new GuestAccount(IDGenerator.getCustomerID(),name,address,phoneNum,username,password);
        accountList.add(newAcc);
        return true;

    }

    public static void displayAllAccount() {
        for (Account account:accountList) {
            account.display();
        }
    }
    public static void displayGuestAccount() {
        for (Account acc:accountList) {
            if (acc instanceof GuestAccount) {
                acc.display();
            }
        }
    }

    public static void displayRegularAccount() {
        for (Account acc:accountList) {
            if (acc instanceof RegularAccount) {
                acc.display();
            }
        }
    }

    public static void displayVIPAccount() {
        for (Account acc:accountList) {
            if (acc instanceof VIPAccount) {
                acc.display();
            }
        }
    }

    // Display all items without any sorting
    public static void displayAllItem() {
        for (Item item:itemList) {
            item.display();
        }
    }

    //Display list of items sorted by item's ID (Complete)
    public static void displayItemSortByID() {
        Collections.sort(itemList, new SortItemByID());
        displayAllItem();
    }

    //Display list of items sorted by item's title (Complete)
    public static void displayItemSortByTitle() {
        Collections.sort(itemList, new SortItemByTitle());
        displayAllItem();
    }

    //Display list of accounts sorted by account's ID (Complete)
    public static void displayAccountSortByID() {
        Collections.sort(accountList, new SortAccountByID());
        displayAllAccount();
    }
    //Display list of accounts sorted by account's name (Complete)
    public static void displayAccountSortByName() {
        Collections.sort(accountList, new SortAccountByName());
        displayAllAccount();
    }
    public static void findItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search with ID or title:");
        String searchBar = sc.nextLine();
        Item tempItem = SearchEngine.searchItem(searchBar);

        if (tempItem == null){
            System.out.println("Error 6");
        }
        else
            tempItem.display();
    }

    public static void findCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search with ID or title:");
        String searchBar = sc.nextLine();
        Account tempAccount = SearchEngine.searchCustomer(searchBar);

        if (tempAccount == null){
            System.out.println("Error 6");
        }
        else
            tempAccount.display();
    }


}
