package com.snake;

import com.snake.builder.EatDotBuilderFabric;
import com.snake.model.Board;
import com.snake.model.Snake;

import static com.snake.builder.EatDotBuilderFabric.BuilderType.CLASSIC;

public class Application {

    public static void main(String[] args) {
        while (true) {
            Board board = new Board(20, 10, new EatDotBuilderFabric().getBuilder(CLASSIC));
            board.doGame();
        }
    }
}
