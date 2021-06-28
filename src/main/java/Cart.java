import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Cart {
    private Map<StoreItem, Integer> order;
    static List<Double> endSum = new ArrayList<>();

    public Cart() {
        this.order = new HashMap<>();
    }

    public void addToCart(StoreItem item, Integer quantity) {
        this.order.put(item, quantity);
    }

    public Map<StoreItem, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<StoreItem, Integer> order) {
        this.order = order;
    }

    public double getTotalPrice() {
        AtomicReference<Double> total = new AtomicReference<>(0.0);

        order.forEach((item, quantity) -> total.set(total.get() + item.getPrice() * quantity));

        return total.get();
    }

    public double getTotalWithDiscount() {
        AtomicReference<Double> total = new AtomicReference<>(0.0);

        order.forEach((item, quantity) -> total.set(total.get() + item.getWithDiscount() * quantity));

        return total.get();
    }

    public void listOrderedProducts() {
        order.forEach((storeItem, quantity) -> {
            System.out.println("====================");
            System.out.println(storeItem);
            System.out.println("Количество: " + quantity);
        });

        DecimalFormat df = new DecimalFormat("###.##");
        double total = getTotalPrice();
        double withDiscount = getTotalWithDiscount();
        double discount = total - withDiscount;
        endSum.add(withDiscount);

        System.out.println("ОБЩО: " + df.format(total) + " $");
        System.out.println("ОТСТЪПКА: -" + df.format(discount) + " $");

        System.out.println("ОБЩО ЗА ПЛАЩАНЕ: " + df.format(withDiscount) + " $");
        order.clear();
    }

    public static void listOrderedProductsSum() {
        DecimalFormat df = new DecimalFormat("###.##");
        double endSumProducts = 0.0;
        for(int i=0; i<endSum.size(); i++){
            endSumProducts += endSum.get(i);
        }
        System.out.println("ОБЩО ЗА ПЛАЩАНЕ: " + df.format(endSumProducts) + " $");
        System.out.println("Дата на касовия бон: " + LocalDate.now());
        endSum.clear();
    }
}
