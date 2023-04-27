package code;
public class DVD extends Item{
    private String genre;
    public DVD(String id, String title, String rentalType, String loanType,int stock, double rentalFee, String genre) {
        super(id, title, rentalType, loanType, stock, rentalFee);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void display() {
        System.out.println("Item{" +
                "id='" + super.getId() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", rentalType='" + super.getRentalType() + '\'' +
                ", loanType='" + super.getLoanType() + '\'' +
                ", rentalFee=" + super.getRentalFee() +
                ", rentalStatus=" + super.isRentalStatus() +
                ", genre=" + getGenre() +
                '}');
    }
}
