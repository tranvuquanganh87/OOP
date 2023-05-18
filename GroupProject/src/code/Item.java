package code;

public abstract class Item {
    private String id;
    private String title;
    private String rentalType;
    private String loanType;
    public int numberOfCopies;
    private double rentalFee;
    private boolean rentalStatus;

    private String itemID;

    public Item(String id, String title, String rentalType, String loanType,int stock, double rentalFee) {
        this.id = id;
        this.title = title;
        this.rentalType = rentalType;
        this.loanType = loanType;
        this.rentalFee = rentalFee;;
        this.numberOfCopies = stock;
        this.rentalStatus = (numberOfCopies > 0) ? true : false;


        IDGenerator idGenerator = new IDGenerator();
        this.itemID = idGenerator.getItemID();
    }

    public Item() {
        this.id = "";
        this.title = "";
        this.rentalType = "";
        this.loanType = "";
        this.numberOfCopies = 0;
        this.rentalFee = 0.0;
        this.rentalStatus = false;

        IDGenerator idGenerator = new IDGenerator();
        this.itemID = idGenerator.getItemID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        String[] availableType = {"2-day loan","1-week loan"};
        boolean matched = false;
        while (!matched) {
            for (String type : availableType) {
                if (loanType.equals(type)) {
                    matched = true;
                    break;
                }
            }

            if (matched) {
                this.loanType = loanType;
                break;
            } else
                System.out.println("Invalid Loan Type! Please enter '2-day loan' or '1-week loan'");
        }
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getNumberOfCopies() {
        return this.numberOfCopies;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public boolean isRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public abstract void display();

}
