package com.eleader.controller;

import com.eleader.domain.Reservation;
import com.eleader.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Konrad on 2017-05-24.
 */
@RestController
@RequestMapping(value = "/reservations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Reservation> getAllReservations(){

        return reservationService.getAllReservations();
    }

    @RequestMapping(value = "/{idReservation}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Reservation getReservationById(@PathVariable Long idReservation){

        return reservationService.getReservationById(idReservation);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Reservation processAddNewReservation(@RequestBody Reservation reservation){

        return  reservationService.saveReservation(reservation);
    }

    @RequestMapping(value = "/delete/{idReservation}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable Long idRent){

        reservationService.deleteReservation(idRent);
    }
}