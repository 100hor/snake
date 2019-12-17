package com.snake.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.snake.model.MoveEvent.MoveEventType.*;

public class Snake {

    private final List<Point> snakePoints;
    private final Direction direction;


    public Snake(List<Point> snakePoints, Direction direction) {
        this.snakePoints = snakePoints;
        this.direction = direction;
    }

    public List<Point> getSnakePoints() {
        return snakePoints;
    }

    public Direction getDirection() {
        return direction;
    }

    private Direction newDirection(MoveEvent moveEvent) {
        switch (direction) {
            case UP:
            case DOWN:
                if (moveEvent.getType() == MOVE_LEFT) {
                    return Direction.LEFT;
                } else if (moveEvent.getType() == MOVE_RIGTH) {
                    return Direction.RIGHT;
                }
                break;
            case RIGHT:
            case LEFT:
                if (moveEvent.getType() == MOVE_DOWN) {
                    return Direction.DOWN;
                }
                if (moveEvent.getType() == MOVE_UP) {
                    return Direction.UP;
                }
                break;
        }
        return direction;
    }

    public Snake move(MoveEvent moveEvent, boolean isDotEaten) {
        List<Point> newSnake = new ArrayList<>();
        final Point head = snakePoints.get(0);
        int newSnakeSize = snakePoints.size();
        if (isDotEaten){
            newSnakeSize++;
        }
        switch (moveEvent.getType()) {
            case MOVE_RIGTH: {
                newSnake.add(0, new Point(head.getX() + 1, head.getY()));
                for (int i = 1; i < newSnakeSize; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_UP: {
                newSnake.add(0, new Point(head.getX(), head.getY() - 1));
                for (int i = 1; i < newSnakeSize; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_DOWN: {
                newSnake.add(0, new Point(head.getX(), head.getY() + 1));
                for (int i = 1; i < newSnakeSize; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_LEFT: {
                newSnake.add(0, new Point(head.getX() - 1, head.getY()));
                for (int i = 1; i < newSnakeSize; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;

            default:
                throw new IllegalArgumentException("Invalid move state");

        }
        return new Snake(newSnake, newDirection(moveEvent));
    }

    public boolean isDotEaten(EatDot dot) {
        return snakePoints.get(0).equals(dot.getPoints());
    }



    public boolean isMoveValid(MoveEvent moveEvent) {
        switch (moveEvent.getType()) {
            case MOVE_UP:
                if (direction != Direction.DOWN)
                    return true;
                break;
            case MOVE_DOWN:
                if (direction != Direction.UP)
                    return true;
                break;
            case MOVE_LEFT:
                if (direction != Direction.RIGHT)
                    return true;
                break;

            case MOVE_RIGTH:
                if (direction != Direction.LEFT)
                    return true;
                break;
            default:
                throw new IllegalArgumentException("Invalid move state");

        }
        return false;
    }

    public boolean isGameOver(int width, int height) {
        for (int i = 1; i < snakePoints.size(); i++) {
            final Point head = snakePoints.get(0);
            if (head.equals(snakePoints.get(i)))
                return true;
            if (head.getX() < 0 || head.getY() < 0 || head.getX() > width || head.getY() > height) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snake snake = (Snake) o;
        return snakePoints.equals(snake.snakePoints) &&
                direction == snake.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(snakePoints, direction);
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
