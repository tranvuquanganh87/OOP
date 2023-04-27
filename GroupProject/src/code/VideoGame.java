package code;
public class VideoGame extends Item{
    public VideoGame(String id, String title, String rentalType, String loanType,int stock, double rentalFee) {
        super(id, title, rentalType, loanType,stock, rentalFee);
    }

    public void display() {
        System.out.println("Item{" +
                "id='" + super.getId() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", rentalType='" + super.getRentalType() + '\'' +
                ", loanType='" + super.getLoanType() + '\'' +
                ", rentalFee=" + super.getRentalFee() +
                ", rentalStatus=" + super.isRentalStatus() +
                '}');
    }
}
