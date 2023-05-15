package com.class1;

import java.util.Scanner;

public class Person {
    int id;
    String name;
    String email;
    String address;
    String phone;
    public Person(){

    }

    public Person(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name :");
        this.name = sc.nextLine();
        System.out.println("Enter email :");
        this.email = sc.nextLine();
        System.out.println("Enter address :");
        this.address = sc.nextLine();
        System.out.println("Enter phone :");
        this.phone = sc.nextLine();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString(){
        return this.id + ", " +
                this.name + ", " +
                this.email + ", " +
                this.address +", "+
                this.phone;
    }
}
