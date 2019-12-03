package com.snake.model;

public class MoveEvent {
    private final MoveEventType type;

    public MoveEvent(MoveEventType type) {
        this.type = type;
    }

    public MoveEventType getType() {
        return type;
    }

    public enum MoveEventType {
        MOVE_RIGTH,
        MOVE_LEFT,
        MOVE_DOWN,
        MOVE_UP,
    }
}
