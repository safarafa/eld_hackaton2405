package com.eleader.domain;

import javax.persistence.*;

/**
 * Created by Konrad on 2017-05-24.
 */
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservation;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "idRoom")
    private Room room;

    private double totalPrice;

    private String description;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}