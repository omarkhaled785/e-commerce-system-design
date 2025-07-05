import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create products
        Product cheese = new Product("Cheese", 100, 5);
        cheese.setExpiry(LocalDate.now().plusDays(5));
        cheese.setShipping(200);

        Product biscuits = new Product("Biscuits", 150, 3);
        biscuits.setExpiry(LocalDate.now()); 
        biscuits.setShipping(700);

        Product tv = new Product("TV", 1000, 10);
        tv.setShipping(8000);

        Product card = new Product("Card", 50, 20);

        // Create customer with their cart
        Customer customer = new Customer("Ahmed", 1000);
        Cart cart = customer.getCart(); 

        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(card, 1);
        } catch (Exception e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
        // Checkout process
        checkout(customer);
    }

    public static void checkout(Customer customer) {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            if (p.isExpired()) {
                p.reduceQuantity(p.getQuantity());
                System.out.println("Error: Product " + p.getName() + " is expired.");
                return;
            }
            if (item.getQuantity() > p.getQuantity()) {
                System.out.println("Error: Not enough stock for " + p.getName());
                System.out.println("Our max stock for now for " + p.getName() + " is " + p.getQuantity());
                return;
            }
        }

       
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            if (p.requiresShipping()) {
                shippables.add(item);
            }
        }

        double subtotal = cart.getSubtotal();
        double shippingFee =  ShippingService.ship(shippables) * 10;
        double totalAmount = subtotal + shippingFee;

         if (customer.getBalance() < totalAmount) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

         // Reduce stock
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        // Payment
        customer.pay(totalAmount);

        // Receipt
        System.out.println("\n- * Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-10s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("-----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFee);
        System.out.printf("Amount\t\t%.0f\n", totalAmount);
        System.out.printf("Remaining Balance: %.0f\n", customer.getBalance());
    }
}
