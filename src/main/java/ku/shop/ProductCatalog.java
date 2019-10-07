package ku.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(String name, double price) {
        products.put(name, new Product(name, price));
    }

    public void addProduct(String name, double price, int quantity) {
        products.put(name, new Product(name, price, quantity));
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public void checkProductQuantity(String name, int q) {
        int quantity = products.get(name).getQuantity();
        if (quantity >= q) {
            int remaining = quantity - q;
            products.get(name).setQuantity(remaining);
        } else {
            throw new IllegalArgumentException("Product not enough.");
        }
    }
}
