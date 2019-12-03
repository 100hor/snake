package com.snake.model;

import java.util.HashMap;
import java.util.Map;

import static com.snake.model.MoveEvent.MoveEventType.*;

public class PlayerMoveEventPool {

    public final Map<String, MoveEvent> pool;

    public PlayerMoveEventPool() {
        Map<String, MoveEvent> pool = new HashMap<>();
        pool.put("w", new MoveEvent(MOVE_UP));
        pool.put("s", new MoveEvent(MOVE_DOWN));
        pool.put("a", new MoveEvent(MOVE_LEFT));
        pool.put("d", new MoveEvent(MOVE_RIGTH));
        this.pool = pool;
    }

//    public Map<String, MoveEvent> getPool() {
//        return pool;
//    }
}
