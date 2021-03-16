package de.aspect;

import de.zoo.Animal;
import de.zoo.food.Food;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnimalAspect {
//    @Pointcut("execution(* de.zoo.Animal.voice())")
//    public void voicePoint() {
//    }

    @Pointcut("execution (* de.zoo.*.*(..))")
    public void anyAnimalMethod() {
    }

//    @Pointcut("within (de.zoo.*)")
//    public void anyAnimalMethodWithWithIn() {
//    }
//
//    @Pointcut("@annotation(de.aspect.annotationMarker.Marker)")
//    public void annotationPointcut() {
//    }
//
//    @Pointcut("@within(de.aspect.annotationMarker.Marker)")
//    public void annotationWithInPointcut() {
//    }

    @Pointcut("args(food)")
    public void withArg(Food food) {
    }

//    @Before(value = "voicePoint()")
//    public void beforeVoice(JoinPoint joinPoint) {
//        System.out.println("beforeVoice");
//    }

    @Before(value = "anyAnimalMethod() && withArg(food)", argNames = "food")
    public void beforeSetFood(Food food) {
        System.out.println(food.toString());
    }

//    @Before(value = "annotationWithInPointcut()")
//    public void beforeServiceCall(JoinPoint joinPoint) {
//        System.out.println("beforeVoice");
//    }

    @AfterReturning(value = "execution(* de.zoo.Animal.isHungry())", returning = "isHungry")
    public void isHungry(boolean isHungry) {
        System.out.println(isHungry);
    }

//    @AfterReturning(value = "execution(* de.zoo.Animal.getAge())", returning = "age")
//    public void afterReturningExample(Integer age) {
//        System.out.println(age);
//    }

//    @AfterThrowing(value = "execution(* de.zoo.Animal.throwException())", throwing = "e")
//    public void afterThrowing(Throwable e) {
//        System.out.println(e.getMessage());
//    }

//    @Around(value = "anyAnimalMethod() && withArg(food)", argNames = "joinPoint,food")
//    public Object around(ProceedingJoinPoint joinPoint, Food food) throws Throwable {
//        Object result = null;
//        //before
//        try {
//            result = joinPoint.proceed();
//            //after returning
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            //after throwing
//            throw throwable;
//        }finally {
//            //after
//        }
//        return result;
//    }
}
