package com.eleader.service;

import com.eleader.domain.Room;
import com.eleader.repository.RoomRepository;
import com.eleader.service.Exception.RoomAlreadyExstsException;
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

        Room existingRoom = roomRepository.findOne(room.getIdRoom());

        if(existingRoom != null){
            throw new RoomAlreadyExstsException("There already exists a room with id" + room.getIdRoom());
        }

        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long idRoom) {
        roomRepository.delete(idRoom);
    }
}
