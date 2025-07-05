public class Customer {
    private String name;
    private double balance;
    private Cart cart = new Cart(this);

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void pay(double amount) {
        if (balance < amount) {
            throw new IllegalStateException("Insufficient balance.");
        }
        balance -= amount;
    }
    
    public void addToBalance(int money){
        this.balance+=money;
    }
    public double getBalance() {
        return balance;
    }
}
