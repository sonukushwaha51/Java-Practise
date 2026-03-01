package design.patterns.factory;

public class OrderConfirmEvent implements EventHandler {
    @Override
    public Event generateEvent() {
        Event event = new Event();
        event.setEventId("ORDER_CONFIRMED");
        return event;
    }
}
