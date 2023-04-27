package utilities;
import java.io.*;
import code.*;
import java.util.ArrayList;
import java.util.Collections;

public class Database {
    // Load Account Database (Complete)
    public static ArrayList<Account> loadAccountData() {
        ArrayList<Account> accountList = new ArrayList<Account>();
        File dir = new File(".\\database\\customer.txt");
        BufferedReader inputStream = null;
        String line;

        // Correct file path to Account database
        try {
            inputStream = new BufferedReader(new FileReader(dir));
            while ((line = inputStream.readLine()) != null) {
                String[] tokens = line.split(",");
                ArrayList<Item> rentalList = new ArrayList<Item>();

                // Extract data from each record(line)
                String customerID = tokens[0];
                String name = tokens[1];
                String address = tokens[2];
                String phoneNumber = tokens[3];
                int rentalQuantity = Integer.parseInt(tokens[4]);
                String accountType = tokens[5];
                String username = tokens[6].strip();
                String pwd = tokens[7].strip();

                if (rentalQuantity > 0) {
                    for (int i = 0; i < rentalQuantity; i++) {
                        String itemID = inputStream.readLine();
                        Item itemFind = VideoStore.findItem(itemID);
                        if (itemFind != null) {
                            rentalList.add(VideoStore.findItem(itemID));
                        }
                    }
                }

                if (accountType.equals("VIP")) {
                    Account newAcc = new VIPAccount(customerID, name, address, phoneNumber,rentalList, username, pwd);
                    accountList.add(newAcc);
                } else if (accountType.equals("Regular")) {
                    Account newAcc = new RegularAccount(customerID, name, address, phoneNumber,rentalList,username, pwd);
                    accountList.add(newAcc);
                } else {
                    Account newAcc = new GuestAccount(customerID, name, address, phoneNumber,rentalList,username, pwd);
                    accountList.add(newAcc);
                }
            }

            // Incorrect file path
        } catch (IOException e) {
            System.out.println("Fail to open file!");
        }

        // Load Account data
        return accountList;
    }

    // Load Item Database (Complete)
    public static ArrayList<Item> loadItemData(){
        ArrayList<Item> itemList = new ArrayList<Item>();
        File dir = new File(".\\database\\item.txt");
        BufferedReader inputStream = null;
        String line;

        //Correct file path to Account database
        try {
            inputStream = new BufferedReader(new FileReader(dir));
            while ((line = inputStream.readLine()) != null) {
                String[] tokens = line.split(",");

                // Extract data from each record(line)
                String itemID = tokens[0];
                String name = tokens[1];
                String itemType = tokens[2];
                String loanType = tokens[3];
                int stock = Integer.parseInt(tokens[4]);
                double rentalPrice = Double.parseDouble(tokens[5]);


                if (itemType.equals("Game")) {
                    Item newItem = new VideoGame(itemID, name, itemType, loanType, stock, rentalPrice);
                    itemList.add(newItem);
                } else if (itemType.equals("Record")) {
                    String genre = tokens[6];
                    Item newItem = new OldMovieRecord(itemID, name, itemType, loanType, stock, rentalPrice,genre);
                    itemList.add(newItem);
                } else {
                    String genre = tokens[6];
                    Item newItem = new DVD(itemID, name, itemType, loanType, stock, rentalPrice, genre);
                    itemList.add(newItem);
                }
            }
            inputStream.close();

            // Error file path
        } catch(IOException e) {
            System.out.println("Fail to open file!");
        }

        // Load Item data
        return itemList;
}

    // Save Account to database (Complete)
    public static void saveAccountData() {
        File dir = new File(".\\database\\customer.txt");
        BufferedWriter outputStream = null;
        try {
            outputStream = new BufferedWriter(new FileWriter(dir));
            // Object casting to save different kind of items to database file
            Collections.sort(VideoStore.getAccountList(),new SortAccountByID());
            for (Account account : VideoStore.getAccountList()) {
                String accountType;
                if (account instanceof GuestAccount) accountType = "Guest";
                else if (account instanceof RegularAccount) accountType = "Regular";
                else accountType = "VIP";

                outputStream.write(account.getId() + ',' + account.getName() + ',' +
                        account.getAddress() + ',' + account.getPhoneNumber() + ',' + account.getRentalList().size()
                        + ',' + accountType + ", " + account.getUsername() + ", " + account.getPassword() + '\n');

                for (Item item: account.getRentalList()) {
                    outputStream.write(item.getId() + '\n');
                }
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Fail to create file!");
        }
    }

    // Save Item to database (Complete)
    public static void saveItemData(){
        File dir = new File(".\\database\\item.txt");
        BufferedWriter outputStream = null;
        try {
            outputStream = new BufferedWriter(new FileWriter(dir));

            Collections.sort(VideoStore.getItemList(), new SortItemByID());
            // Object casting to save different kind of items to database file
            for (Item item: VideoStore.getItemList()) {
                if (item instanceof VideoGame)
                    outputStream.write(item.getId() + ',' +
                            item.getTitle() + ',' + item.getRentalType() + ',' + item.getLoanType() + ',' +
                            item.getNumberOfCopies() + ',' + item.getRentalFee() + '\n');
                else if (item instanceof DVD) {
                    outputStream.write(item.getId() + ',' +
                            item.getTitle() + ',' + item.getRentalType() + ',' + item.getLoanType() + ',' +
                            item.getNumberOfCopies() + ',' + item.getRentalFee() + ',' + ((DVD) item).getGenre() + "\n");
                } else {
                    outputStream.write(item.getId() + ',' +
                            item.getTitle() + ',' + item.getRentalType() + ',' + item.getLoanType() + ',' +
                            item.getNumberOfCopies() + ',' + item.getRentalFee() + ',' + ((OldMovieRecord) item).getGenre() + "\n");
                }
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Fail to create file!");
        }
    }
}
