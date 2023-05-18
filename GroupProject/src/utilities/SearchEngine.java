package utilities;

import code.Account;
import code.Item;
import code.VideoStore;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    public static Item searchItem(String searchBar){
        for (Item item: VideoStore.getItemList()) {
            if ((item.getTitle().equals(searchBar)) || (item.getId().equals(searchBar))) {
                return item;
            }
        }

        System.out.println("Item not found!");
        return null;
    }

    public static Account searchCustomer(String searchBar){
        for (Account account: VideoStore.getAccountList()) {
            if ((account.getCustomerID().equals(searchBar)) || (account.getName().equals(searchBar))) {
                return account;
            }
        }

        System.out.println("Customer not found!");
        return null;
    }

}
