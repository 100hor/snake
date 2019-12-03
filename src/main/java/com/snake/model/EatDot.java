package com.snake.model;


import java.util.Objects;

public class EatDot {
    private final Point points;
    private int weight;


    public EatDot(Point points, int weight) {
        this.points = points;
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
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
