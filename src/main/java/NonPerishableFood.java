public class NonPerishableFood extends StoreItem implements Taxable, Expirable {

    public NonPerishableFood(String name, String brand, double price) {
        super(name, brand, price);
    }

    @Override
    public boolean doesExpire() {
        return false;
    }

    @Override
    public double getWithDiscount() {
        return price;
    }

    @Override
    public String toString() {
        return "ТРАЙНА ХРАНА" +
                "\nИме: " + name
                + "\nМарка: " + brand
                + "\nЦена: $" + price
                + "\n\n";
    }
}
