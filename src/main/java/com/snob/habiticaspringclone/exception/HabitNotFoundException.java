package com.snob.habiticaspringclone.exception;

public class HabitNotFoundException extends RuntimeException{
    public HabitNotFoundException(String message) {
        super(message);
    }
}
