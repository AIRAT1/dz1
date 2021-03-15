package de.impl;

import de.aspect.annotationMarker.Marker;
import de.zoo.Animal;
import de.zoo.AnimalService;
import de.zoo.food.Food;
import org.springframework.stereotype.Service;

@Service
@Marker
public class AnimalServiceImpl implements AnimalService {
    @Override
    public void feedAnimal(Food food, Animal animal) {
        animal.feed(food);
    }
}
