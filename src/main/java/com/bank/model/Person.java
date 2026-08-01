package com.bank.model;

public abstract class Person {
    protected int id;
    protected String name;
    protected String cnic;
    protected String phone;

    public Person(int id, String name, String cnic, String phone) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
