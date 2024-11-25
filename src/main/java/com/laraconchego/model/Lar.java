package com.laraconchego.model;

public class Lar {

    private String id;
    private String name;

    public Lar(String name) {
        this.name = name;
    }

    public Lar(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
