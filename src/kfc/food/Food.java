package kfc.food;

/**
 * Base class of all types of food.
 */
public class Food {

    private int id;
    private String name;
    private float price;
    private float calorie;

    public Food () {

    }

    protected void setId(int id) {
        this.id = id;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    protected void setCalorie(float calorie) {
        this.calorie = calorie;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getCalorie() {
        return calorie;
    }
}
