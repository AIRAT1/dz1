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
public class Cow implements Animal {
    private Food food;
    private Integer age = 10;

    @Override
    public void voice() {
        System.out.println("mu");
    }

    @Override
    public void feed(Food food) {
        this.food = food;
    }

    @Override
    public void throwException() {

    }
}
