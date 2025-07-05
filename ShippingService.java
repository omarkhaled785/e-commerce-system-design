import java.util.List;

public class ShippingService {
    public static double ship(List<Shippable> items) {
        double totalWeight = 0;

        if (items.isEmpty()) {
            return 0;
        }

        System.out.println("\n- * Shipment notice **\n");
        for (Shippable item : items) {
            System.out.println(item.getName() + "\t" + (int)item.getWeight() + "g");
            totalWeight += item.getWeight();
        }
        
        System.out.printf("\nTotal package weight for shippable items only : %.2fkg\n\n", totalWeight / 1000);
        return totalWeight / 1000;
    }
}
