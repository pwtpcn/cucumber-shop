package ku.shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} and stock of {int} exists")
    public void a_product_exists(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @Given("the product {string} is available")
    public void the_product_is_available(String name) {
        Product product = catalog.getProduct(name);
        assertEquals(true, product.getStock() > 0);
    }

    @When("I check the stock for {string}")
    public void i_check_the_stock_for(String name) {}

    @Then("the stock for {string} should be {int}")
    public void the_stock_for_should_be(String name, int expectedStock) {
        Product product = catalog.getProduct(name);
        assertEquals(expectedStock, product.getStock());
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) throws OutOfStockException {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
}

