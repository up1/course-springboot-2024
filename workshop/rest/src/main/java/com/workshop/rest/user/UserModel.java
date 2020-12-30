package com.workshop.rest.user;

public class UserModel {
    private int id;
    private String name;
    private int age;

    public UserModel() {
        this("", 0);
    }

    public UserModel(String name, int age) {
        this(0, name, age);
    }

    public UserModel(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
