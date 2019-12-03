package com.snake.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EatDotBuilderFabric {
    private final Map<BuilderType, EatDotBuilder> eatDotBuilderByType;

    public EatDotBuilderFabric() {
        Map<BuilderType, EatDotBuilder> eatDotBuilder = new HashMap<>();
        eatDotBuilder.put(BuilderType.CLASSIC, new ClassicEatDotBuilder());
        this.eatDotBuilderByType = Collections.unmodifiableMap(eatDotBuilder);
    }

    public EatDotBuilder getBuilder(BuilderType type) {
        return eatDotBuilderByType.get((type));
    }

    public enum BuilderType {
        CLASSIC
    }
}
