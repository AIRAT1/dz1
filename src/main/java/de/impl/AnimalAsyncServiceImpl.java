package de.impl;

import de.zoo.Animal;
import de.zoo.AnimalAsyncService;
import de.zoo.food.Food;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AnimalAsyncServiceImpl implements AnimalAsyncService {
    @Async
    @Override
    public void feed(Animal animal, Food food) {

    }
}
