package ku.shop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("we have these products")
    public void we_have_these_products(DataTable table) {
        List<List<String>> list = table.asLists(String.class);
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).get(0);
            double price = Double.parseDouble(list.get(i).get(1));
            int quantity = Integer.parseInt(list.get(i).get(2));
            catalog.addProduct(name, price, quantity);
        }
    }

    @When("I buy (.+) with quantity (.+) less than quantity")
    public void i_buy_less_than_quantity(String name, int quant) {
        catalog.checkProductQuantity(name, quant);
    }

    @When("I buy (.+) with quantity (.+) more than quantity")
    public void i_buy_more_than_quantity(String name, int quant) {
        assertThrows(IllegalArgumentException.class,
                () -> catalog.checkProductQuantity(name, quant));
    }

    @Then("remaining quantity of (.+) is (.+)")
    public void remaining_quantity_is(String name, int quantity) {
        assertEquals(quantity, catalog.getProduct(name).getQuantity());
    }

    @Given("ร้านมีสินค้า")
    public void ร้านมีสินค้า(DataTable table) {
        Map<String, Double> data = table.asMap(String.class, Double.class);

        for (String name : data.keySet()) {
            double price = data.get(name);
            catalog.addProduct(name, price);
        }
    }

    @Given("a product (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @When("ฉันซื้อ (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
}

