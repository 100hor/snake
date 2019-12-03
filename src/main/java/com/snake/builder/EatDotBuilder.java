package com.snake.builder;

import com.snake.model.EatDot;

public interface EatDotBuilder {
    EatDot next(int weight, int height);
}
