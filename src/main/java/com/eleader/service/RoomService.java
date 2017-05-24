package com.eleader.service;

import com.eleader.domain.Customer;
import com.eleader.domain.Room;

/**
 * Created by Konrad on 2017-05-24.
 */
public interface RoomService {

    Iterable<Room> getAllRooms();

    Room getRoomById(Long idRoom);

    Room saveRoom(Room room);
}
