package com.example.fragment_tablayout_viewpageper2.model;

public class Order {
    private int id;
    private String name;
    private String status;

    public Order(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
