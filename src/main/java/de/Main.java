package de;

import de.configuration.AnnotationConfiguration;
import de.configuration.BeanConfiguration;
import de.zoo.Animal;
import de.zoo.AnimalService;
import de.zoo.food.Food;
import de.zoo.food.FoodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext("annotationConfiguration");
        AnimalService animalService = context.getBean("animalServiceImpl", AnimalService.class);
        Animal cat = context.getBean("cat", Animal.class);
        Animal dog = context.getBean("dog", Animal.class);
        Animal cow = context.getBean("cow", Animal.class);
        animalService.feedAnimal(
                Food.builder()
                        .expiredDate(LocalDateTime.now().plusMinutes(3L))
                        .foodType(FoodType.FISH)
                        .value(BigDecimal.valueOf(10)).build(),
                cat
        );
        animalService.feedAnimal(
                Food.builder()
                        .expiredDate(LocalDateTime.now().plusMinutes(3L))
                        .foodType(FoodType.MEAT)
                        .value(BigDecimal.valueOf(10)).build(),
                dog
        );
        animalService.feedAnimal(
                Food.builder()
                        .expiredDate(LocalDateTime.now().plusMinutes(3L))
                        .foodType(FoodType.MEAT)
                        .value(BigDecimal.valueOf(10)).build(),
                cow
        );
//        cat.getAge();
//        dog.getAge();
//        cow.getAge();

        cat.isHungry(cat);
        dog.isHungry(dog);
        cow.isHungry(cow);
//        cat.throwException();
    }

    private static ApplicationContext getAnnotationContext(String profile) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles(profile);
        annotationConfigApplicationContext.register(AnnotationConfiguration.class, BeanConfiguration.class);
        annotationConfigApplicationContext.refresh();
        return annotationConfigApplicationContext;
    }
}
