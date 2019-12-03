package com.snake.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    private Direction setDirection(MoveEvent moveEvent) {
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

    public Snake move(MoveEvent moveEvent) {
        List<Point> newSnake = new ArrayList<>();
        switch (moveEvent.getType()) {
            case MOVE_RIGTH: {
                newSnake.add(0, new Point(snakePoints.get(0).getX() + 1, snakePoints.get(0).getY()));
                for (int i = 1; i < snakePoints.size(); i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_UP: {
                newSnake.add(0, new Point(snakePoints.get(0).getX(), snakePoints.get(0).getY() - 1));
                for (int i = 1; i < snakePoints.size(); i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_DOWN: {
                newSnake.add(0, new Point(snakePoints.get(0).getX(), snakePoints.get(0).getY() + 1));
                for (int i = 1; i < snakePoints.size(); i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_LEFT: {
                newSnake.add(0, new Point(snakePoints.get(0).getX() - 1, snakePoints.get(0).getY()));
                for (int i = 1; i < snakePoints.size(); i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;

            default:
                throw new IllegalArgumentException("Invalid move state");

        }
        return new Snake(newSnake, setDirection(moveEvent));
    }

    public boolean isDotEaten(EatDot dot) {
        if (snakePoints.get(0).equals(dot.getPoints()))
            return true;
        else return false;
    }

    public Snake moveByEatDot(MoveEvent moveEvent) {
        List<Point> newSnake = new ArrayList<>();
        switch (moveEvent.getType()) {
            case MOVE_RIGTH: {
                newSnake.add(0, new Point(snakePoints.get(0).getX() + 1, snakePoints.get(0).getY()));
                for (int i = 1; i < snakePoints.size() + 1; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_UP: {
                newSnake.add(0, new Point(snakePoints.get(0).getX(), snakePoints.get(0).getY() - 1));
                for (int i = 1; i < snakePoints.size() + 1; i++) {
                    newSnake.add(i, snakePoints.get(i-1));
                }
            }
            break;
            case MOVE_DOWN: {
                newSnake.add(0, new Point(snakePoints.get(0).getX(), snakePoints.get(0).getY() + 1));
                for (int i = 1; i < snakePoints.size() + 1; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;
            case MOVE_LEFT: {
                newSnake.add(0, new Point(snakePoints.get(0).getX() - 1, snakePoints.get(0).getY()));
                for (int i = 1; i < snakePoints.size() + 1; i++) {
                    newSnake.add(i, snakePoints.get(i - 1));
                }
            }
            break;

            default:
                throw new IllegalArgumentException("Invalid move state");

        }
        return new Snake(newSnake, setDirection(moveEvent));
    }

    public boolean isMoveValid(MoveEvent moveEvent) {
        boolean isValid = false;
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
        return isValid;
    }

    public boolean isGameOver(int width, int height) {
        for (int i = 1; i < snakePoints.size() - 1; i++) {
            if (snakePoints.get(0).equals(snakePoints.get(i)))
                return true;
            if (snakePoints.get(0).getX() < 0 || snakePoints.get(0).getX() > width || snakePoints.get(0).getY() > height) {
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
