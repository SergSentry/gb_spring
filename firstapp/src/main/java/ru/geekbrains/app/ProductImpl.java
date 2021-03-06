package ru.geekbrains.app;

public class ProductImpl implements Product {
    private int id = 0;
    private String title = "";
    private float cost = 0.0f;

    public ProductImpl(int id, String title, float cost) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("title");
        if (cost < 0.0)
            throw new IllegalArgumentException("cost");

        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public float getCost() {
        return this.cost;
    }

    public String toString() {
        return String.format("%d. '%s' %2.2f$", this.id, this.title, this.cost);
    }
}
