package de.zoo;

import de.zoo.Animal;
import de.zoo.food.Food;

public interface AnimalAsyncService {
    void feed(Animal animal, Food food);
}
