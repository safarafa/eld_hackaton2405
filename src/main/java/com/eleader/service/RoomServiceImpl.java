package com.eleader.service;

import com.eleader.domain.Room;
import com.eleader.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Konrad on 2017-05-24.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long idRoom) {
        return roomRepository.findOne(idRoom);
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
}
