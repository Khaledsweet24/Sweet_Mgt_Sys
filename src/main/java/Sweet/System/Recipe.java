package Sweet.System;

public class Recipe {

    private String title;
    private String description;

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return
                "title:" + title + '\'' +
                ", description:" + description + '\'' +
                '}';
    }
}
