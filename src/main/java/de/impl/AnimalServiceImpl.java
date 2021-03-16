package de.impl;

import de.aspect.annotationMarker.Marker;
import de.zoo.Animal;
import de.zoo.AnimalService;
import de.zoo.food.Food;
import de.zoo.food.FoodType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Marker
public class AnimalServiceImpl implements AnimalService {
    @Override
    public boolean checkRightFood(Food food, Animal animal) {
        if ((animal instanceof Cat && food.getFoodType() != FoodType.FISH) ||
                (animal instanceof Dog && food.getFoodType() != FoodType.MEAT) ||
                (animal instanceof Cow && food.getFoodType() != FoodType.GRAS) ||
                (!food.getExpiredDate().isAfter(LocalDateTime.now()))) {
            logMethod(food, animal);
            throw new RuntimeException("Choice right food for animal");
        }
        return true;
    }

    private void logMethod(Food food, Animal animal) {
        System.out.println("Expired Date" + food.getExpiredDate());
        System.out.println("LocalDateTime.now() " + LocalDateTime.now());
        System.out.println("Animal class " + animal.getClass());
        System.out.println("FoodType is " + food.getFoodType());
    }

    @Override
    public void feedAnimal(Food food, Animal animal) {

        animal.feed(food);
    }
}
