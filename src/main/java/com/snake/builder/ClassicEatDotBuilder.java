package com.snake.builder;

import com.snake.model.EatDot;
import com.snake.model.Point;

public class ClassicEatDotBuilder implements EatDotBuilder {
    @Override
    public EatDot next(int width, int height) {
        return new EatDot(new Point(randomCoordinateForDot(width), randomCoordinateForDot(height)));
    }

    private int randomCoordinateForDot(int max) {
        return (int) (Math.random() * max);
    }
}
