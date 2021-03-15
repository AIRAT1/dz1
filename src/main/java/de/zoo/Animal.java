package de.zoo;

import de.aspect.annotationMarker.IsHungry;
import de.zoo.food.Food;

import java.util.Random;

public interface Animal {
    void voice();
    void feed(Food food);
    Integer getAge();
    void throwException();
    @IsHungry
    default boolean isHungry(Animal animal) {
        Random random = new Random();
        return random.nextInt(2) == 0;
    };
}
