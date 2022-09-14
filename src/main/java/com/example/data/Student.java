package com.example.data;

@SuppressWarnings("ALL")
public class Student {

    private static String name;

    private static int rollNo;

    private static String email;
    private Address address;
    private Standard standard;

    public Student() {
    }

    public Student(String name, int rollNo, String email, Address address, Standard standard) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.address = address;
        this.standard = standard;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getRollNo() {
        return Integer.parseInt(String.valueOf(rollNo));
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return String.valueOf(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", standard=" + standard +
                '}';
    }





    }

