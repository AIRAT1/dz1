package de.zoo;

import de.zoo.food.Food;

public interface Animal {
    void voice();
    void feed(Food food);
    Integer getAge();
    void throwException();
}
