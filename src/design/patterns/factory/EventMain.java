package design.patterns.factory;

public class EventMain {
    public static void main(String[] args) {
        EventHandler eventHandler = EventFactory.createEvent("ORDER_DELIVERED");

        Event event = eventHandler.generateEvent();

        System.out.println("Event generated for: "+ event.getEventId());
    }
}
