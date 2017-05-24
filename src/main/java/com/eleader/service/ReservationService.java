package com.eleader.service;

import com.eleader.domain.Reservation;

/**
 * Created by Konrad on 2017-05-24.
 */
public interface ReservationService {

    Iterable<Reservation> getAllReservations();

    Reservation getReservationById(Long idRent);

    Reservation saveReservation(Reservation rent);

    void deleteReservation(Long idRent);
}
