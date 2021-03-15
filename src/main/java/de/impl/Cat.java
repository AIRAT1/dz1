package de.impl;

import de.aspect.annotationMarker.IsHungry;
import de.zoo.Animal;
import de.zoo.food.Food;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Qualifier("catQualifier")
@Getter
@Setter
@IsHungry
public class Cat implements Animal {
    private Food food;
    private Integer age = 3;

    @Override
    public void voice() {
        System.out.println("mi");
    }

    @Override
    public void feed(Food food) {
        this.food = food;
    }

    @Override
    public void throwException() {
        throw new RuntimeException("aaaaa");
    }
}
