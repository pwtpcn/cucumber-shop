package ku.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private LocalDateTime date;

    public Order() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public void addItem(Product prod, int quantity) throws OutOfStockException{
        if(prod.getStock() > 0 && prod.getStock() > quantity) {
            items.add(new OrderItem(prod, quantity));
            prod.cutStock(quantity);
        } else {
            throw new OutOfStockException("Item '" + prod.getName() + "' is out of stock.");
        }
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items)
            total += item.getSubtotal();
        return total;
    }
}
