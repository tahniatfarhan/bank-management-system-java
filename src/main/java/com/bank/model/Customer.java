package com.bank.model;

public class Customer extends Person {
    private String address;

    public Customer(int id, String name, String cnic, String phone, String address) {
        super(id, name, cnic, phone);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getCnic() {
        return cnic;
    }

    public String getPhone() {
        return phone;
    }
}
