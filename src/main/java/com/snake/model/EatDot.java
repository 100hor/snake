package com.snake.model;


import java.util.Objects;

public class EatDot {
    private final Point points;


    public EatDot(Point points) {
        this.points = points;
    }




    public Point getPoints() {
        return points;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EatDot eatDot = (EatDot) o;
        return Objects.equals(points, eatDot.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
