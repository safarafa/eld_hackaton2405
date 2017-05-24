package com.eleader.repository;

import com.eleader.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Konrad on 2017-05-24.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
