package design.patterns.factory;

public class OrderDeliveredEvent implements EventHandler {
    @Override
    public Event generateEvent() {
        Event event = new Event();
        event.setEventId("ORDER_DELIVERED");
        return event;
    }
}
