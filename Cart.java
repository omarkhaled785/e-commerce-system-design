import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();
    private Customer customer;


    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    
    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity exceeds available stock for " + product.getName());
        }
        if(product.isExpired()){
            throw new IllegalArgumentException("Requested product " + product.getName() +  " is expired for now ");
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return items; }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
