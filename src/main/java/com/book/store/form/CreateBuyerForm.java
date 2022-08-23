package com.book.store.form;

import javax.validation.constraints.NotEmpty;

public class CreateBuyerForm {

    @NotEmpty(message = "Field cannot be empty")
    private String firstName;

    @NotEmpty(message = "Field cannot be empty")
    private String lastName;

    @NotEmpty(message = "Field cannot be empty")
    private String address;

    @NotEmpty(message = "Field cannot be empty")
    private String business_name;

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

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }
}
