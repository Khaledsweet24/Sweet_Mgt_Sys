package Sweet.System;

public class Recipe {

    private String title;
    private String description;
    private String Nutrient,Calories,Fat,Sugar,Protein;

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Recipe(String title, String description,String Nutrient ) {
        this.title = title;
        this.description = description;
        this.Nutrient = Nutrient;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }

    public String getFat() {
        return Fat;
    }

    public void setFat(String fat) {
        Fat = fat;
    }

    public String getSugar() {
        return Sugar;
    }

    public void setSugar(String sugar) {
        Sugar = sugar;
    }

    public String getProtein() {
        return Protein;
    }

    public void setProtein(String protein) {
        Protein = protein;
    }

    public String getNutrient() {return Nutrient;}

    public void setNutrient(String Nutrient) {
        this.Nutrient = Nutrient;
    }

    @Override
    public String toString() {
        return
                title + ": " + description + "\n";
    }
}
