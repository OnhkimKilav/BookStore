package ua.mikhno.bookStore.models;

public enum Status{
    NEW("New"),
    IN_PROCESSING("In processing"),
    SENT("Sent"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private final String displayValue;

    Status(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
