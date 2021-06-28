import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<StoreItem, Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
        loadInventory();
    }

    private void loadInventory() {
        inventory.put(new NonPerishableFood("Солети", "Храна", 1.90), 10);
        inventory.put(new PerishableFood("Ябълка", "Храна", 1.90, LocalDate.of(2021, 6, 28)), 8);
        inventory.put(new Beverage("Мляко", "Напитки", 1.80), 12);
        inventory.put(new Clothes("Тениска", "Дрехи", 20.2,"М"), 8);
        inventory.put(new Appliances("Laptop", "Техника", 1002.26, "Acer", LocalDate.of(2021, 6, 20), 1.5), 10);
    }

    public void showInventory() {
        inventory.forEach((storeItem, quantity) -> {
            System.out.println("====================");
            System.out.println(storeItem);
            System.out.println("Количество: " + quantity);
        });
    }

    public boolean hasEnough(String item, int requested) {
        StoreItem targetItem = inventory.keySet()
                .stream()
                .filter(key -> key.name.equals(item))
                .findFirst()
                .orElse(null);

        return inventory.get(targetItem) >= requested;
    }

    public boolean hasProduct(String item) {
        if (item.isEmpty()) {
            return true;
        }

        return inventory.keySet()
                .stream()
                .anyMatch(key -> key.name.equals(item));
    }

    public StoreItem getAndResetQuantity(String name, int quantity) {
        StoreItem targetItem = inventory.keySet()
                .stream()
                .filter(key -> key.name.equals(name))
                .findFirst()
                .orElse(null);

        int oldQuantity = inventory.get(targetItem);
        inventory.put(targetItem, oldQuantity - quantity);
        return targetItem;
    }
}
