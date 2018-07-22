package models;

import java.util.ArrayList;

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

    public String getCategoryName() {
        return this.categoryName;
    }

    public static Category findByName(String name) {
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(Category.UK);
        categoryList.add(Category.WORLD);
        categoryList.add(Category.POLITICS);
        categoryList.add(Category.SCIENCE);
        categoryList.add(Category.SPORTS);

        for (Category category : categoryList) {
            if (category.getCategoryName() == name) {
                return category;
            }
        }
        return null;
    }


//
//        for ( Category category : categoryList)
//        if(category.getCategoryName() == name){return category;}
//        return null;


}
