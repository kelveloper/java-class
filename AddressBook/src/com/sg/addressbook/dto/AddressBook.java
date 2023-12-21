package com.sg.addressbook.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private String firstName;
    private String lastName;
    private String address;

    public AddressBook(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) { this.address = address; }

}
