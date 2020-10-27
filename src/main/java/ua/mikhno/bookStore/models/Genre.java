package ua.mikhno.bookStore.models;

public enum Genre{
    HISTORY("History"),
    BIOGRAPHY("Biography"),
    HISTORICAL_NOVEL("Historical novel"),
    BOOKS_FOR_CHILDREN("Books for children"),
    MILITANT("Militant"),
    DETECTIVE("Detective"),
    ROMANCE_NOVEL("Romance novel"),
    FANTASY("Fantasy"),
    MYSTIC("Mystic"),
    ADVENTURE_STORY("Adventure story");

    private final String displayValue;

    Genre(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
