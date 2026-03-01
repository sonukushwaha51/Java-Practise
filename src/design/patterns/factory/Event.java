package design.patterns.factory;

import java.util.Map;

public class Event {

    private String eventId;

    private String eventUuid;

    private long timestamp;

    private Map<String, Object> fields;

    public Event() {
    }

    public Event(String eventId, String eventUuid, long timestamp, Map<String, Object> fields) {
        this.eventId = eventId;
        this.eventUuid = eventUuid;
        this.timestamp = timestamp;
        this.fields = fields;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventUuid() {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid) {
        this.eventUuid = eventUuid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}
