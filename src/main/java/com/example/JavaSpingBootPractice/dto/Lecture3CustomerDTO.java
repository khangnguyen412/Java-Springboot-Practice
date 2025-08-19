package com.example.JavaSpingBootPractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Lecture3CustomerDTO {
    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String cust_type_cd;

    @NotBlank(message = "Fed id is required")
    @Size(min = 9, max = 12, message = "Mã số định danh phải từ 9 đến 12 ký tự")
    private String fed_id;

    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$", message = "Mã postal code không hợp lệ")
    private String postal_code;

    @NotBlank(message = "State is required")
    @Size(min = 2, max = 2, message = "Mã state phải có 2 ký tự")
    private String state;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCust_type_cd() {
        return cust_type_cd;
    }

    public void setCust_type_cd(String cust_type_cd) {
        this.cust_type_cd = cust_type_cd;
    }

    public String getFed_id() {
        return fed_id;
    }

    public void setFed_id(String fed_id) {
        this.fed_id = fed_id;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
