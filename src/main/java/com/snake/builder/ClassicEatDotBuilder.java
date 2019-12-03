package com.snake.builder;

import com.snake.model.Board;
import com.snake.model.EatDot;
import com.snake.model.Point;

public class ClassicEatDotBuilder implements EatDotBuilder {
    @Override
    public EatDot next(int width, int height) {

        EatDot dot = new EatDot(new Point(randomCoordinateForDot(width), randomCoordinateForDot(height)), 1);
        return dot;
    }

    private int randomCoordinateForDot(int max) {
        max -= 1;
        return (int) (Math.random() * ++max);
    }
}
