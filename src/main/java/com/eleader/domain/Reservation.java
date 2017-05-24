package com.eleader.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "reservation")
    private List<Room> room;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dateReservation;

    private double totalPrice;

    private String description;
}
