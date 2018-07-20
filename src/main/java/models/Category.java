package models;

public enum Category {

    UK("UK"),
    WORLD("World"),
    POLITICS("Politics"),
    SCIENCE("Science"),
    SPORTS("Sports");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
