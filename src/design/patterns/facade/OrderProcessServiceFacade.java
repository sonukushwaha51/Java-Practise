package design.patterns.facade;
public class OrderProcessServiceFacade {

    private InventoryService inventoryService;

    private OrderService orderService;

    private PaymentService paymentService;

    public OrderProcessServiceFacade() {
        this.inventoryService = new InventoryService();
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
    }

    public void processOrder(String skuId, double amount, String userId) {
        inventoryService.deductInventory(skuId);
        orderService.createOrder(skuId, userId);
        boolean payment = paymentService.doPayment(amount);
        if (payment) {
            System.out.println("Order placed");
        } else {
            System.out.println("Order failed");
        }
    }

}

class InventoryService {

    public int returnInventory(String skuId) {
        return 100;
    }

    public void deductInventory(String skuId) {
        int inventory = returnInventory(skuId);
        inventory--;
        saveInventory(skuId, inventory);
        System.out.println("Inventory deducted");
    }

    public void saveInventory(String skuId, int inventory) {
        //
    }
}

class OrderService {

    public void createOrder(String skuId, String userId) {
        System.out.println("Order created");
    }
}

class PaymentService {
    public boolean doPayment(double amount) {
        System.out.println("Payment done");
        return true;
    }
}

class FacadeDemo {
    public static void main(String[] args) {
        OrderProcessServiceFacade orderProcessServiceFacade = new OrderProcessServiceFacade();

        orderProcessServiceFacade.processOrder("157171",2862.00,"9898372");
        System.out.println("Order flow completed");
    }
}