package de.impl;

import de.aspect.annotationMarker.Marker;
import de.zoo.Animal;
import de.zoo.AnimalService;
import de.zoo.food.Food;
import de.zoo.food.FoodType;
import org.springframework.stereotype.Service;

@Service
@Marker
public class AnimalServiceImpl implements AnimalService {
    @Override
    public void feedAnimal(Food food, Animal animal) {
        if ((animal instanceof Cat && food.getFoodType() != FoodType.FISH) ||
                (animal instanceof Dog && food.getFoodType() != FoodType.MEAT) ||
                (animal instanceof Cow && food.getFoodType() != FoodType.GRAS)) {

            throw new RuntimeException("Choice right food for animal");
        }
        animal.feed(food);
    }
}
