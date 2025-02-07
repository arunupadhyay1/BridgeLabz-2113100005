public class OrderTest {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder();
        order.orderId = 101;
        order.orderDate = "2023-10-01";
        order.trackingNumber = "TRACK123";
        order.deliveryDate = "2023-10-05";
        System.out.println(order.getOrderStatus());
    }
}

class Order {
    int orderId;
    String orderDate;

    String getOrderStatus() {
        return "Order Status: Pending";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    String getOrderStatus() {
        return "Order Status: Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    String getOrderStatus() {
        return "Order Status: Delivered";
    }
}

