package de.zoo;

import de.zoo.food.Food;

public interface AnimalService {
    boolean checkRightFood(Food food, Animal animal);
    void feedAnimal(Food food, Animal animal);
}
