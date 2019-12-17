package com.snake.model;

import com.snake.builder.EatDotBuilder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int height;
    private final int width;
    private EatDotBuilder dotBuilder;
    private EatDot dotOnBoard;
    private Snake snake;
    private final Player player;


    public Board(int width, int height,/* Snake startSnake,*/ EatDotBuilder dotBuilder) {
        this.height = height;
        this.width = width;
        this.dotBuilder = dotBuilder;
        this.dotOnBoard = dotBuilder.next(width, height);
        List<Point> points = new ArrayList<>();
        points.add(new Point(7, 5));
        points.add(new Point(6, 5));
        points.add(new Point(5, 5));
        this.snake = new Snake(points, Snake.Direction.RIGHT);
        this.player = new Player();
    }


    public void doGame() {
        while (true) {
            System.out.println(getStringState());
            System.out.println("-----------------------------------------");
            MoveEvent moveEvent = player.getNextMoveEvent();
            if (!snake.isMoveValid(moveEvent))
                continue;
            if (snake.isDotEaten(dotOnBoard)) {
                snake = snake.move(moveEvent,snake.isDotEaten(dotOnBoard));
                dotOnBoard = dotBuilder.next(width, height);
            } else {
                snake = snake.move(moveEvent,snake.isDotEaten(dotOnBoard));
            }
            if (snake.isGameOver(width, height))
                break;

        }
    }

    public String getStringState() {
        final char[][] charBoard = new char[height + 1][width + 1];
        snake.getSnakePoints().forEach(point -> charBoard[point.getY()][point.getX()] = '*');
        charBoard[dotOnBoard.getPoints().getY()][dotOnBoard.getPoints().getX()] = '#';
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            builder.append('-');
        }
        builder.append('\n');
        for (char[] chars : charBoard) {
            builder.append('|');
            builder.append(chars);
            builder.append('|');
            builder.append('\n');

        }
        return builder.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
