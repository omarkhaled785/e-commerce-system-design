public class CartItem implements Shippable {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity){
        this.quantity += quantity;
    }

    @Override
    public String getName() {
        return quantity + "x " + product.getName();
    }

    @Override
    public double getWeight() {
        return quantity * product.getWeight();
    }
}
