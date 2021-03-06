package de.impl;

import de.aspect.annotationMarker.IsHungry;
import de.zoo.Animal;
import de.zoo.food.Food;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@IsHungry
public class Dog implements Animal {
    private Food food;
    private Integer age = 5;

    @Override
    public void voice() {
        System.out.println("gav");
    }

    @Override
    public void feed(Food food) {
        this.food = food;
    }

    @Override
    public void throwException() {

    }
}
