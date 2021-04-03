package ru.geekbrains.app;

public class Product {
    private int _id = 0;
    private String _title = "";
    private float _cost = 0.0f;

    public Product(int id, String title, float cost) {
        _id = id;
        _title = title;
        _cost = cost;
    }

    public int getId() {
        return _id;
    }

    public String getTitle() {
        return _title;
    }

    public float getCost() {
        return _cost;
    }

    @Override
    public String toString() {
        return String.format("%d. '%s' %2.2f$", _id, _title, _cost);
    }
}
