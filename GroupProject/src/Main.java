import java.io.IOException;
import utilities.*;
import code.*;

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
        VideoStore.displayRegularAccount();
        Database.saveItemData();
        Database.saveAccountData();

    }
}
