package design.patterns.factory;

public class EventFactory {

    public enum ORDER_TYPE {
        ORDER_DELIVERED,
        ORDER_CONFIRMED
    };

    public static EventHandler createEvent(String messageType) {

        if (messageType.equals(ORDER_TYPE.ORDER_CONFIRMED.name())) {
            return new OrderConfirmEvent();
        } else if (messageType.equals(ORDER_TYPE.ORDER_DELIVERED.name())) {
            return new OrderDeliveredEvent();
        }
        return null;
    }

}
