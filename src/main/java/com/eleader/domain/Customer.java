package com.eleader.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Konrad on 2017-05-24.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @Column(columnDefinition = "VARCHAR(11)")
    @NotNull
    @Size(min = 11)
    private String pesel;

    @Column(columnDefinition = "VARCHAR(6)")
    @Size(min = 6)
    private String zipCode;

    @Size(max = 50)
    private String city;

    @Size(max = 50)
    private String street;

    @Size(max = 5)
    private String apartNr;

    @Column(columnDefinition = "VARCHAR(9)")
    @Size(min = 9)
    @NotNull
    private String phoneNumber;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartNr() {
        return apartNr;
    }

    public void setApartNr(String apartNr) {
        this.apartNr = apartNr;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
