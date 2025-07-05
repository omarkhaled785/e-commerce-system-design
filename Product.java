import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean requiresShipping;
    private Double weight; // in grams, null if not shippable
    private LocalDate expiryDate; // may be null also

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setShipping(double weight) {
        this.requiresShipping = true;
        this.weight = weight;
    }

    public void setExpiry(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return (expiryDate != null && LocalDate.now().isAfter(expiryDate));
    }

    public boolean requiresShipping() {
        return requiresShipping;
    }

    public double getWeight() {
        if (!requiresShipping) throw new IllegalStateException("Item not shippable");
        return weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public void reduceQuantity(int amount) {
        if (quantity < amount) throw new IllegalArgumentException("Not enough stock for " + name);
        quantity -= amount;
    }
}
