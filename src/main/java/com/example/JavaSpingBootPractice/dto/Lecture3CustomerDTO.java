package com.example.JavaSpingBootPractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.example.JavaSpingBootPractice.validation.annotation.Lecture3FedidValid;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lecture3CustomerDTO {
    @NotBlank(message = "Address is required")
    @JsonProperty("address")
    private String address;

    @NotBlank(message = "City is required")
    @JsonProperty("city")
    private String city;

    @NotBlank(message = "State is required")
    @JsonProperty("cust_type_cd")
    private String cust_type_cd;

    @NotBlank(message = "Fed id is required")
    @Lecture3FedidValid
    private String fed_id;

    @NotBlank(message = "Postal code is required")
    @JsonProperty("postal_code")
    @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$", message = "Mã postal code không hợp lệ")
    private String postal_code;

    @NotBlank(message = "State is required")
    @JsonProperty("state")
    @Size(min = 2, max = 2, message = "Mã state phải có 2 ký tự")
    private String state;

    /*
     * Set property
     */
    public void set_address(String address) {
        this.address = address;
    }

    public void set_city(String city) {
        this.city = city;
    }

    public void set_cust_type_cd(String cust_type_cd) {
        this.cust_type_cd = cust_type_cd;
    }

    public void set_fed_id(String fed_id) {
        this.fed_id = fed_id;
    }

    public void set_postal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void set_state(String state) {
        this.state = state;
    }

    /**
     * Get property
     */
    public String get_address() {
        return address;
    }

    public String get_city() {
        return city;
    }

    public String get_cust_type_cd() {
        return cust_type_cd;
    }

    public String get_fed_id() {
        return fed_id;
    }

    public String get_postal_code() {
        return postal_code;
    }

    public String get_state() {
        return state;
    }

}
