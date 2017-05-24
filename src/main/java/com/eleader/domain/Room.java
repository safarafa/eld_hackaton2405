package com.eleader.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Konrad on 2017-05-24.
 */
@Entity
@Table(name = "ROOMS")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRoom;

    @ManyToOne
    @JoinColumn(name = "idReservation")
    private Reservation reservation;

    @NotNull
    private int seats;
}
