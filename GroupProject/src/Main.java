import code.VideoStore;
import utilities.Database;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        if (!VideoStore.addCustomer()) {
//            System.out.println("A");
//        };
//
//        if (!VideoStore.addCustomer()) {
//            System.out.println("A");
//        };

//        VideoStore.displayAllCustomer();
//        VideoStore.displayItemSortByID();
//        VideoStore.displayItemSortByTitle();
//        VideoStore.displayAccountSortByID();
//        VideoStore.displayAccountSortByName();
//        VideoStore.displayGuestAccount();
//        VideoStore.displayVIPAccount();
//        VideoStore.displayRegularAccount();
//        System.out.println(VideoStore.getItemList().size());



//        VideoStore.addCustomer();
//        VideoStore.addCustomer();

        VideoStore.findCustomer();
        Database.saveItemData();
        Database.saveAccountData();

    }
}
