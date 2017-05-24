package com.eleader.controller;

import com.eleader.domain.Customer;
import com.eleader.domain.Room;
import com.eleader.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Konrad on 2017-05-24.
 */
@RestController
@RequestMapping(value = "/rooms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomReservation {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Room> getAllRooms(){

        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Room createNewCustomer(@RequestBody Room room){

        return roomService.saveRoom(room);
    }

    @RequestMapping(value = "/{idRoom}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Room getRoom(@PathVariable Long idRoom){

        return roomService.getRoomById(idRoom);
    }

    @RequestMapping(value = "/delete/{idRoom}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable Long idRoom){

        roomService.deleteRoom(idRoom);
    }
}
