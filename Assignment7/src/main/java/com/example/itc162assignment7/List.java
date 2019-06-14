package com.example.itc162assignment7;

public class List {

    private int id;
    private String name;

    List() {}

    public List(String name) {
        this.name = name;
    }

    List(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void setId(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}