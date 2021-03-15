package de;

import de.configuration.AnnotationConfiguration;
import de.configuration.BeanConfiguration;
import de.zoo.Animal;
import de.zoo.AnimalService;
import de.zoo.food.Food;
import de.zoo.food.FoodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext("annotationConfiguration");
        AnimalService animalService = context.getBean("animalServiceImpl", AnimalService.class);
        Animal cat = context.getBean("cat", Animal.class);
        Animal dog = context.getBean("dog", Animal.class);
        Animal cow = context.getBean("cow", Animal.class);
        List<Animal> animals = Stream.of(cat, dog, cow).collect(Collectors.toList());

        for (Animal animal : animals) {
            animal.isHungry();
        }

        extracted(animalService, animals);
    }

    @Scheduled(cron = "*/3 * * * * *")
    public static void extracted(AnimalService animalService, List<Animal> animals) {
        Random random = new Random();

        for (Animal animal : animals) {
            if (animal.isHungry()) {
                int randomInt = random.nextInt(3);
                animal.voice();
                animalService.feedAnimal(
                        Food.builder()
                                .expiredDate(LocalDateTime.now().plusMinutes(randomInt))
                                .foodType(FoodType.values()[randomInt])
                                .value(BigDecimal.valueOf(randomInt * 2 + 1)).build(),
                        animal
                );
            }
        }
    }

    public static ApplicationContext getAnnotationContext(String profile) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles(profile);
        annotationConfigApplicationContext.register(AnnotationConfiguration.class, BeanConfiguration.class);
        annotationConfigApplicationContext.refresh();
        return annotationConfigApplicationContext;
    }
}
