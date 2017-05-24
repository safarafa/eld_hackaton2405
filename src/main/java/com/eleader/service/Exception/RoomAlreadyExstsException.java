package com.eleader.service.Exception;

/**
 * Created by Konrad on 2017-05-24.
 */
public class RoomAlreadyExstsException extends RuntimeException{
    public RoomAlreadyExstsException(String message) {
        super(message);
    }
}
