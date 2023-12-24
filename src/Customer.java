public class Customer {
    private String customerId;
    private String name;
    private String email;
    private double walletBalance;

    public Customer(String customerId, String name, String email, double walletBalance) {
        this.customerId=customerId;
        this.name=name;
        this.email=email;
        this.walletBalance=walletBalance;
    }
    public String getCustomerId() { return customerId;}   public void setCustomerId(String customerId) {this.customerId=customerId;}
    public String getName() { return name;}   public void setName(String name) {this.name=name;}
    public String getEmail() { return email;}   public void setEmail(String email) {this.email=email;}
    public double getWalletBalance() { return walletBalance;}   public void setWalletBalance(double walletBalance) {this.walletBalance=walletBalance;}


    public String toString(){

        return "Customer id: " + customerId + "\nCustomer name: " + name + "\nEmail: " + email + "\nBalance: " + walletBalance;
    }


}