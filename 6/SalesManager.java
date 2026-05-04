import java.util.*;

public class SalesManager {
    private TreeMap<String, Integer> sales = new TreeMap<>();
    private double totalRevenue = 0;

    public void addSale(String product, double price) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
        totalRevenue += price;
    }

    public void printSalesList() {
        System.out.println("--- Список проданных товаров (по алфавиту) ---");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + " — продано: " + entry.getValue());
        }
    }

    public void printStatistics() {
        System.out.println("Общая сумма продаж: " + totalRevenue);
        String popular = null;
        int maxSales = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                popular = entry.getKey();
            }
        }
        System.out.println("Наиболее популярный товар: " + popular);
    }

    public static void main(String[] args) {
        SalesManager manager = new SalesManager();
        manager.addSale("Ноутбук", 75000);
        manager.addSale("Мышь", 1500);
        manager.addSale("Ноутбук", 75000);

        manager.printSalesList();
        manager.printStatistics();
    }
}
