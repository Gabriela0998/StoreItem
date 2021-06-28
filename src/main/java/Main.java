import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.showInventory();

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Въведете брой продукти");
            Integer countProduct = scanner.nextInt();
            String name="";
         while (countProduct>0) {
             System.out.println("Въведете продукт (или order за край)");
             name = scanner.next();

                 if ("order".equals(name)) {
                     cart.listOrderedProducts();
                     break;
                 }
                 if (!inventory.hasProduct(name)) {
                     System.err.println("Моля, въведете съществуващ продукт");
                     inventory.showInventory();
                     continue;
                 }

                 System.out.println("Въведете количество");
                 int quantity = scanner.nextInt();

                 if (!inventory.hasEnough(name, quantity)) {
                     System.err.println("Недостатъчна наличност");
                     inventory.showInventory();
                     continue;
                 }

                 cart.addToCart(inventory.getAndResetQuantity(name, quantity), quantity);
                 System.out.println("Добавени продукти в количка: \n");
                 cart.listOrderedProducts();
                 System.out.println("====================");
                 countProduct--;
                 name = "";
         }
            Cart.listOrderedProductsSum();
        }
    }
}
