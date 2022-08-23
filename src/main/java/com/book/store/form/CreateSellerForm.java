package com.book.store.form;

import javax.validation.constraints.NotEmpty;

public class CreateSellerForm {

    @NotEmpty(message = "Field cannot be empty")
    private String firstName;

    @NotEmpty(message = "Field cannot be empty")
    private String lastName;

    @NotEmpty(message = "Field cannot be empty")
    private String address;

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

    public void setAddress(String address) {
        this.address = address;
    }
}
